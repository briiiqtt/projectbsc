package com.jamong.projectbsc.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jamong.projectbsc.service.TransactionService;

@Component
public class DistributionScheduler {
	
	@Autowired TransactionService ts;

	@Scheduled(cron = "0 0 13 * * *")
	public void c() {
		System.out.println("dddddd");
		System.out.println("dddddd");
		System.out.println("dddddd");
		System.out.println("dddddd");
		System.out.println("dddddd");
	}
	
	@Scheduled(cron = "33 22 10 * * *")
	public void scheduleDistribution() {
		List<Map<String,String>> transactionLog = new ArrayList<>();
		List<Map<String,String>> list = ts.getUserRankedBetween("1", "10");
		for(Map<String,String> a : list) {
			transactionLog.add(ts.distributeToken(a.get("ADDRESS")));
		}
		
		System.out.println(transactionLog);
		
	}
	
}