package com.jamong.projectbsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamong.projectbsc.service.TestService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired TestService testService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/gettime")
	public String getTime(Model model) {
		model.addAttribute("time", testService.getTime());
		return "home";
	}
	
}
