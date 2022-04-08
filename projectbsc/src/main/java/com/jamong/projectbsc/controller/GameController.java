package com.jamong.projectbsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/game")
	public String getGamePage() {
		return "game/game";
	}
	
}
