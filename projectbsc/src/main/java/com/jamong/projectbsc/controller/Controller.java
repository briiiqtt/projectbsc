package com.jamong.projectbsc.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
}
