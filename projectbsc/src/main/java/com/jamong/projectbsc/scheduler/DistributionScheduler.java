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

	@Scheduled(cron = "0 0 17 * * *")
	public void scheduleDistribution() {
		//1등: 30 MNGTK
		List<Map<String,String>> rankers = ts.getUserRankedBetween("1", "1");
		for(Map<String,String> ranker : rankers) {
			System.out.println(ranker);
			logMapper.addLog(ts.distributeToken(ranker.get("ADDRESS"),30));
		}
		rankers = null;
		//2등: 20 MNGTK
		rankers = ts.getUserRankedBetween("2", "2");
		for(Map<String,String> ranker : rankers) {
			System.out.println(ranker);
			logMapper.addLog(ts.distributeToken(ranker.get("ADDRESS"),20));
		}
		rankers = null;
		//3등: 10 MNGTK
		rankers = ts.getUserRankedBetween("3", "3");
		for(Map<String,String> ranker : rankers) {
			System.out.println(ranker);
			logMapper.addLog(ts.distributeToken(ranker.get("ADDRESS"),10));
		}
		
	}
	
}