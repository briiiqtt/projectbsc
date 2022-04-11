package com.jamong.projectbsc.service;

import java.util.List;
import java.util.Map;

import com.jamong.projectbsc.mapper.ScoreMapper;

public interface TransactionService {

	Map<String, String> distributeToken(String to);
	List<Map<String,String>> getUserRankedBetween(String high, String low);
	
}
