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

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamong.projectbsc.mapper.ScoreMapper;
import com.jamong.projectbsc.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	ScoreMapper scoreMapper;

	@Override
	public Map<String, String> distributeToken(String to) {
		Map<String, String> map = new HashMap<>();
		HttpURLConnection con = null;
		try {

			URL url = new URL("https://kip7-api.klaytnapi.com/v1/contract/kip7test/transfer");
			String jsonString = "{\"from\":\"0x80C2272266C86d7d6FA292aB11FE5E5c261955eB\",\"to\":\"" + to
					+ "\",\"amount\":\"0x989680\"}";

			con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("x-chain-id", "1001");
			con.setRequestProperty("Authorization",
					"Basic S0FTS1NLSVBKSE01MzNWQlpOVjQ0RTQyOnNOd1NqM2VoYzNsWVpLd2pzQlNJdXZrU0tWV2NKWTF0b2I1NlRmLWw=");

			OutputStream os = con.getOutputStream();
			byte[] input = jsonString.getBytes("utf-8");
			os.write(input, 0, input.length);

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String responseLine = null;

			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			String responseString = response.toString();
			JSONObject jo = new JSONObject(responseString);

			System.out.println(responseString);

			map.put("status", jo.getString("status"));
			map.put("transactionHash", jo.getString("transactionHash"));

		} catch (IOException e) {
			map.put("status", "error");
			map.put("transactionHash", e.getMessage());

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				String responseString = response.toString();
				JSONObject jo = new JSONObject(responseString);

				System.out.println(responseString);

				map.put("status", jo.getString("message"));
				map.put("transactionHash", String.valueOf(jo.getInt("code")));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public List<Map<String, String>> getUserRankedBetween(String high, String low) {
		Map<String, String> map = new HashMap<>();
		map.put("high", high);
		map.put("low", low);
		return scoreMapper.getRank(map);
	}

}
