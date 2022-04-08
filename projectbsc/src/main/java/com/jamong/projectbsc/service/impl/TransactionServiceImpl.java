package com.jamong.projectbsc.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamong.projectbsc.mapper.ScoreMapper;
import com.jamong.projectbsc.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired ScoreMapper scoreMapper;
	
	public static void main(String[] args) {
		TransactionServiceImpl tsi = new TransactionServiceImpl();

//		tsi.distributeToken("0x9d82fc36c8b80c0454fd0f4262f38d0053befede");
		System.out.println(tsi.getUserRankedBetween("1", "2"));
	}
	
	@Override
	public void distributeToken(String to) {
		try {

			URL url = new URL("https://kip7-api.klaytnapi.com/v1/contract/kip7test/transfer");
			String jsonString = "{\"from\":\"0x80C2272266C86d7d6FA292aB11FE5E5c261955eB\",\"to\":\"" + to
					+ "\",\"amount\":\"0x100\"}";

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("x-chain-id", "1001");
			con.setRequestProperty("Authorization",
					"Basic S0FTS1NLSVBKSE01MzNWQlpOVjQ0RTQyOnNOd1NqM2VoYzNsWVpLd2pzQlNJdXZrU0tWV2NKWTF0b2I1NlRmLWw=");

			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String,String>> getUserRankedBetween(String high, String low) {
		Map<String, String> map = new HashMap<>();
		map.put("high", high);
		map.put("low", low);
		return scoreMapper.getRank(map);
	} 

}
