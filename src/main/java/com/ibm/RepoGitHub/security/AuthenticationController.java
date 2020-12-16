package com.ibm.RepoGitHub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.RepoGitHub.security.dto.LoginInput;
import com.ibm.RepoGitHub.security.dto.TokenAuthenticationResponse;
import com.ibm.RepoGitHub.security.jwt.TokenManager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("Authentication")
@RequestMapping ("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;	
	
	@Autowired
	private TokenManager tokenManager;
	
	@ApiOperation(value = "Auth")
	@ApiResponses({
		@ApiResponse(code = 200, response = TokenAuthenticationResponse.class, message = "OK"),
		@ApiResponse(code = 400, message = "BAD_REQUEST")
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenAuthenticationResponse> login(@RequestBody LoginInput loginInput) {
		UsernamePasswordAuthenticationToken tokenAuthentication =  loginInput.build();
		try {
			Authentication authentication = authenticationManager.authenticate(tokenAuthentication);
			String jwt = tokenManager.generateToken(authentication);
			TokenAuthenticationResponse tokenAuthenticationResponse = new TokenAuthenticationResponse("Bearer", jwt);
			return ResponseEntity.ok(tokenAuthenticationResponse);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
}