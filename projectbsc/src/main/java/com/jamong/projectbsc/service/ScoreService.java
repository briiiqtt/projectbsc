package com.jamong.projectbsc.service;

import java.util.List;
import java.util.Map;

import com.jamong.projectbsc.dto.Score;

public interface ScoreService {
	
	int recordScore(Score score);
	List<Map> getTotalRank();
}
