package com.branch.githubproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubCommitHistoryService {

	@Value("${per_page_limit}")
	private String perPage;
	
	@Value("${branchDetailsUrl}")
	private String branchDetailsUrl;
	
	@Value("${commitDetailsUrl}")
	private String commitDetailsUrl;
	
	private RestTemplate restTemplate = null;

	public String getGitHubBranchs() {
		restTemplate = new RestTemplate();
		String response = null;
		try {
			response = restTemplate.getForObject(branchDetailsUrl, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public String getGitHubCommitHistory(String commitId) {
		restTemplate = new RestTemplate();
		String response = null;
		try {
			StringBuilder urlparams = new StringBuilder(commitDetailsUrl);
			urlparams.append("per_page=").append(perPage).append("&sha=").append(commitId);
			response = restTemplate.getForObject(urlparams.toString(), String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
}
