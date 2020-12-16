package com.ibm.RepoGitHub.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ibm.RepoGitHub.controller.dto.RepositorySummary;

@Service
public class GitHubService {
	
	public List<RepositorySummary> tokenParse(String url) throws Exception {
		List<RepositorySummary> listRepositorySummary = new ArrayList<RepositorySummary>();
		
		String inline = readUrl(url);
		
		JSONArray jArray = new JSONArray(inline);
		
	    for (int i = 0; i < jArray.length(); i++) {
	        RepositorySummary repositorySummary = new RepositorySummary();
	    	JSONObject jsonObj = jArray.getJSONObject(i);
	        repositorySummary.setDescription(jsonObj.get("description").toString());
	        repositorySummary.set_private(Boolean.parseBoolean(jsonObj.get("private").toString()));
	        repositorySummary.setFull_name(jsonObj.get("full_name").toString());
	        repositorySummary.setLanguage(jsonObj.get("language").toString());
	        repositorySummary.setCreated_at(jsonObj.get("created_at").toString());
	        repositorySummary.setName(jsonObj.get("name").toString());
	        repositorySummary.setUpdate_at(jsonObj.get("updated_at").toString());
	        repositorySummary.setOwner(jsonObj.get("owner").toString());
	        listRepositorySummary.add(repositorySummary);
	    }
		return listRepositorySummary;
	}
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read);

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}
