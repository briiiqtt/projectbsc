package com.jamong.projectbsc.mapper;

import java.util.List;
import java.util.Map;

public interface AircraftMapper {
	int addToUser(Map<String,String> map);
	List<Map<String,String>> getAircraftList(Map<String,String> user);
	Map<String,String> findAircraft(Map<String,String> user);
	int changeSelectedToNull(Map<String,String> map);
	int setSelected(Map<String,String> map);
}
