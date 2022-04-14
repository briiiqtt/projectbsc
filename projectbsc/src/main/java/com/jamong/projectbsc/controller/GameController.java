package com.jamong.projectbsc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamong.projectbsc.dto.User;
import com.jamong.projectbsc.mapper.AircraftMapper;
import com.jamong.projectbsc.mapper.UserMapper;
import com.jamong.projectbsc.scheduler.DistributionScheduler;
import com.jamong.projectbsc.service.EquipmentService;

@Controller
public class GameController {

	@Autowired
	DistributionScheduler ds;
	@Autowired
	EquipmentService equipmentService;
	@Autowired
	AircraftMapper aircraftMapper;
	@Autowired
	UserMapper userMapper;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/game")
	public String getGamePage(Model model, @RequestParam Map<String, String> map) {
		User user = new User();
		user.setAddress(map.get("address"));
		model.addAttribute("headerh1", "GAME");
		model.addAttribute("user", userMapper.findUser(user));

		Map<String, String> queryResult = aircraftMapper.findAircraft(map);
		if (queryResult != null) {
			model.addAttribute("hp", queryResult.get("HP"));
		} else {
			model.addAttribute("hp", "15");
		}
		return "game/game";
	}

	@GetMapping("/market")
	public String getShopPage(Model model) {
		model.addAttribute("headerh1", "MARKET");
		return "game/market";
	}

	@ResponseBody
	@GetMapping("/distribute")
	public void distribute() {
		ds.scheduleDistribution();
	}

	@GetMapping("/aircraft")
	@ResponseBody
	public Map<String, String> findAircraft(Map<String, String> user) {
		return equipmentService.findSelectedAircraft(user);
	}

	@PostMapping("/aircraft")
	@ResponseBody
	public void addAircraft(@RequestBody Map<String, String> map) {
		List<Map<String, String>> compare = equipmentService.getAircraftList(map);
		for (Map<String, String> comp : compare) {
			if (comp != null) {
				if (comp.get("METADATA").equals(map.get("metadata"))) {
					System.out.println("이미 등록된 토큰");
					return;
				}
			}
		}
		aircraftMapper.addToUser(map);
	}

	@PutMapping("/aircraft")
	@ResponseBody
	public void changeAircraft(@RequestBody Map<String, String> map) {
		System.out.println(map);
		equipmentService.changeAircraft(map);
	}

	@GetMapping("/equip")
	public String getEquipmentPage(Model model, @RequestParam Map<String, String> map) {
		model.addAttribute("headerh1", "EQUIPMENTS");
		model.addAttribute("aircrafts", equipmentService.getAircraftList(map));
		return "game/equip";
	}

}
