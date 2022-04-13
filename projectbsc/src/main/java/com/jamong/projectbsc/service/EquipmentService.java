package com.jamong.projectbsc.service;

import java.util.List;
import java.util.Map;

public interface EquipmentService {
	Map<String,String> findSelectedAircraft(Map<String,String> map);
	List<Map<String,String>> getAircraftList(Map<String,String> map);
	boolean changeAircraft(Map<String,String> map);
}
