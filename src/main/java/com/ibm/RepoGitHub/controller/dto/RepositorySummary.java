package com.ibm.RepoGitHub.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepositorySummary")
public class RepositorySummary {
	
	@ApiModelProperty("_private")
	private boolean _private;
	
	@ApiModelProperty("created_at")
	private String created_at;
	
	@ApiModelProperty("description")
	private String description;
	
	@ApiModelProperty("name")
	private String name;

	@ApiModelProperty("languange")
	private String language;

	@ApiModelProperty("full_name")
	private String full_name;

	@ApiModelProperty("owner")
	private String owner;
	
	@ApiModelProperty("update_at")
	private String update_at;

	public boolean is_private() {
		return _private;
	}

	public void set_private(boolean _private) {
		this._private = _private;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	
	

}
