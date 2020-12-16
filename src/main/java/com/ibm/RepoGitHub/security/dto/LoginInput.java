package com.ibm.RepoGitHub.security.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "authkey")
public class LoginInput {
	@ApiModelProperty(value = "NAME")
	private String user;
	@ApiModelProperty(value = "PASSWORD")
	private String psw;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	public UsernamePasswordAuthenticationToken build() {
		return new UsernamePasswordAuthenticationToken(this.user, this.psw);
	}
}
