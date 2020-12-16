package com.ibm.RepoGitHub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.RepoGitHub.controller.dto.GithubUser;
import com.ibm.RepoGitHub.controller.dto.RepositorySummary;
import com.ibm.RepoGitHub.service.GitHubService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "git-hub-controller", description = "Git Hub Controller")
@RequestMapping ("/")
public class GitHubController {
	
	@Autowired
	private GitHubService gitHubService;
	
	@ApiOperation(value = "git-hub-controller")
	@ApiResponses({
		@ApiResponse(code = 200, response = String.class, message = "OK"),
		@ApiResponse(code = 201, message = "CREATED"),
		@ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden"),
		@ApiResponse(code = 404, message = "NotFound")
	})
	@PostMapping("/list")
	public ResponseEntity<List<RepositorySummary>> PostGitHub (@RequestBody GithubUser gitHubUser, @RequestHeader (name="Authorization") String token) throws IOException{
		
		String url = "https://api.github.com/users/"+gitHubUser.getUser()+"/repos";
		List<RepositorySummary> listRepositorySummary = new ArrayList<RepositorySummary>();
		
		try {
			listRepositorySummary = gitHubService.tokenParse(url);
			return ResponseEntity.ok(listRepositorySummary);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

		
	}
	

}
