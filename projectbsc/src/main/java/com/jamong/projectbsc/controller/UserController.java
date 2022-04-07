package com.jamong.projectbsc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamong.projectbsc.dto.User;
import com.jamong.projectbsc.service.ScoreService;
import com.jamong.projectbsc.service.UserService;

@Controller
@RequestMapping("/users/")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	ScoreService scoreService;

	@GetMapping("register")
	public String registerUser() {
		return "users/register";
	}

	@PostMapping("register")
	public String addUser(Model model, User user) {
		return userService.addUser(user);
	}

	@GetMapping("rank")
	public String userList(Model model) {
		model.addAttribute("data", scoreService.getTotalRank());
		System.out.println(scoreService.getTotalRank());
		return "users/rank";
	}

//	@PostMapping("login")
//	public String login(Model model, User user) {
//		if (userService.login(user)) {
//			model.addAttribute("userId", user.getId());
//			return "game/game";
//		} else {
//			return "users/error";
//		}
//	}
//
	@GetMapping("getid")
	@ResponseBody
	public Map<String,String> getAddress(Model model, User user) {
		System.out.println(user.getAddress());
		
		Map<String,String> map = new HashMap<>();
		try {
			map.put("id", userService.findUser(user).getId());
		} catch (NullPointerException e) {
			map.put("id", "null");
		}
		return map;
	}

}
