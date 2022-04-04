package com.jamong.projectbsc.mapper;

import java.util.List;
import java.util.Map;

import com.jamong.projectbsc.dto.Score;

public interface ScoreMapper {
	int recordScore(Score score);
	List<Map> getRank();
}
