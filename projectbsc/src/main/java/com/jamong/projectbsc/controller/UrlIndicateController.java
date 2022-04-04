package com.jamong.projectbsc.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class UrlIndicateController {
	
	@GetMapping("/game")
	public String getGamePage() {
		return "game";
	}
	
	@GetMapping("/users/rank")
	public String getRankingPage() {
		return "users/rank";
	}
	
	@GetMapping("/users/register")
	public String registerUser() {
		return "users/register";
	}

}
