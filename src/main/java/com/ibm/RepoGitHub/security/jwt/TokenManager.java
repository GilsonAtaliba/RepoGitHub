package com.ibm.RepoGitHub.security.jwt;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ibm.RepoGitHub.security.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenManager {
	
	private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	public static final String TOKEN_PREFIX = "Bearer ";
	private static final int TOKEN_EXPIRY_DURATION = 10; // in days

	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		
		return Jwts.builder()
			.setSubject(Long.toString(user.getId()))
	        .setExpiration(Date.from(ZonedDateTime.now().plusDays(TOKEN_EXPIRY_DURATION).toInstant()))
	        .signWith(SECRET_KEY)
	        .compact();
  }

	  public Claims parseToken(String token) {
	    return Jwts.parserBuilder()
	        .setSigningKey(SECRET_KEY)
	        .build()
	        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
	        .getBody();
	  }
	
	
	public	boolean	isValid(String	jwt) {
		if(jwt==null) return false;
		try	{ Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(jwt.replace(TOKEN_PREFIX, ""));
			return true;
		} catch (JwtException | IllegalArgumentException e)	{
		return false;
											}
							}
	public Long getUserIdFromToken(String jwt) {
		Claims claims =	parseToken(jwt);
	return	Long.parseLong(claims.getSubject());
							}
	
}
