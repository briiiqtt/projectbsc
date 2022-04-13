package com.jamong.projectbsc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamong.projectbsc.mapper.AircraftMapper;
import com.jamong.projectbsc.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired AircraftMapper aircraftMapper;

	@Override
	public Map<String, String> findSelectedAircraft(Map<String, String> map) {
		return aircraftMapper.findAircraft(map);
	}

	@Override
	public List<Map<String, String>> getAircraftList(Map<String, String> map) {
		return aircraftMapper.getAircraftList(map);
	}

	@Override
	public boolean changeAircraft(Map<String, String> map) {
		try {
		aircraftMapper.changeSelectedToNull(map);
		if(map.get("metadata").equals("default")) {
			System.out.println("set to default");
			return true;
		}
		aircraftMapper.setSelected(map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	

}
