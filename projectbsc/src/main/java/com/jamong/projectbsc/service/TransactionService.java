package com.jamong.projectbsc.service;

import java.util.List;
import java.util.Map;

public interface TransactionService {

	Map<String, String> distributeToken(String to, int amount);
	List<Map<String,String>> getUserRankedBetween(String high, String low);
	
}
