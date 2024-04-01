package com.ipad.project.population.dao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.population.model.RegionDataUpdateVO;

@Repository
public interface IRegionDataUpdateRepository {
	ArrayList<String> selectAdm();
	void insertOtherData(RegionDataUpdateVO vo);
	void insertRegion(String code);
	void updatePopulation(Map<String, Object> map);
	void updateSale(Map<String, Object> map);
	void insertRegionSale(String code);
	ArrayList<String> regionCheck();
	void addRegion(String adm_cd);
}
