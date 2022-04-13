package com.jamong.projectbsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamong.projectbsc.dto.Score;
import com.jamong.projectbsc.service.ScoreService;

@Controller
@RequestMapping("/score/")
public class ScoreController {

	@Autowired ScoreService scoreService;
	
	@PostMapping("record")
	@ResponseBody
	public boolean recordScore(Score score) {
		System.out.println(score);
		scoreService.recordScore(score);
		return true;
	}
	
}
