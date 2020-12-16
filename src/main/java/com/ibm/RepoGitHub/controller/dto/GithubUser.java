package com.ibm.RepoGitHub.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GithubUser")
public class GithubUser {
	@ApiModelProperty("user")
	String user;
	
	@ApiModelProperty("password")
	String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
