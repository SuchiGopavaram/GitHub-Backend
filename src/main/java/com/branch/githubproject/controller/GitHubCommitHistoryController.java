package com.branch.githubproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.branch.githubproject.service.GitHubCommitHistoryService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class GitHubCommitHistoryController {

	@Autowired
	private GitHubCommitHistoryService gitHubCommitHistoryService;
	
	@GetMapping("/heartbeat")
	public HttpStatus message() {
		System.out.println("HeartBeat");
		return HttpStatus.OK;
	}
	
	@GetMapping(value ="/git/branches")
	public String getGetHubBranches() {
		return gitHubCommitHistoryService.getGitHubBranchs();
	}
	
	@GetMapping(value ="/git/commits/{commitId}")
	public String getGetHubCommits(@PathVariable("commitId") String commitId) {
		return gitHubCommitHistoryService.getGitHubCommitHistory(commitId);
	}
	
}
