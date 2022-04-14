package com.jamong.projectbsc.scheduler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jamong.projectbsc.mapper.LogMapper;
import com.jamong.projectbsc.service.TransactionService;

@Component
public class DistributionScheduler {
	
	@Autowired TransactionService ts;
	@Autowired LogMapper logMapper;

	@Scheduled(cron = "0 0 19 * * *")
	public void scheduleDistribution() {
		List<Map<String,String>> rankers = ts.getUserRankedBetween("1", "10");
		for(Map<String,String> ranker : rankers) {
			System.out.println(ranker);
			logMapper.addLog(ts.distributeToken(ranker.get("ADDRESS")));
		}
		
	}
	
}