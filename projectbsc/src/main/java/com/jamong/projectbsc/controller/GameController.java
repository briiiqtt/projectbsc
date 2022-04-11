package com.jamong.projectbsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jamong.projectbsc.scheduler.DistributionScheduler;

@Controller
public class GameController {
	
	@Autowired DistributionScheduler ds;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/game")
	public String getGamePage() {
		return "game/game";
	}
	
	@GetMapping("/distribute")
	public void distribute() {
		ds.scheduleDistribution();
	}
	
}
