package com.jamong.projectbsc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamong.projectbsc.dto.Score;
import com.jamong.projectbsc.mapper.ScoreMapper;
import com.jamong.projectbsc.service.ScoreService;


@Service
public class ScoreServiceImpl implements ScoreService{

	@Autowired ScoreMapper scoreMapper;
	
	@Override
	public int recordScore(Score score) {
		return scoreMapper.recordScore(score);
	}

	@Override
	public List<Map> getTotalRank() {
		return scoreMapper.getRank();
	}

}
