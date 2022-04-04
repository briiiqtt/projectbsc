package com.jamong.projectbsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamong.projectbsc.dto.User;
import com.jamong.projectbsc.service.UserService;

@Controller
@RequestMapping("/users/")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("register")
	public String registerUser() {
		return "users/register";
	}

	@PostMapping("register")
	public String addUser(Model model, User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("list")
	public String userList(Model model) {
		model.addAttribute("users", userService.userList());
		model.addAttribute("");
		return "users/list";
	}
	
}
