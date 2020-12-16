package com.ibm.RepoGitHub.security.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "token")
public class TokenAuthenticationResponse {
	
	@ApiModelProperty(value = "TOKEN_TYPE")
	private String tokenType;
	@ApiModelProperty(value = "TOKEN")
	private String token;
	
	public String getTokenType() {
		return tokenType;
	}
	public String getToken() {
		return token;
	}
	public TokenAuthenticationResponse(String tokenType, String token) {
		this.tokenType = tokenType;
		this.token = token;
	}
	
	
	
	
}
