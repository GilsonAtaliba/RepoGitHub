package com.ibm.RepoGitHub.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class ListRepositorySummary {

	private List<RepositorySummary> list = new ArrayList<RepositorySummary>();

	public List<RepositorySummary> getList() {
		return list;
	}

	public void setList(List<RepositorySummary> list) {
		this.list = list;
	}
	
	
}
