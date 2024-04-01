package com.ipad.project.population.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ipad.project.population.model.RegionDataUpdateVO;

public interface IRegionDataUpdateService {

	void setVO();

	ArrayList<String> selectAdm();

	void insertRegion();

	void insertOtherData(RegionDataUpdateVO vo);

	String fetchDataFromAPI(String code, int age) throws IOException;

	String fetchDataFromAPI() throws IOException;

	void insertData();

	String getToken();

	JsonNode parseJsonData(String jsonData) throws IOException;

	void updateSale(String adm_cd);
	
	void addRegion();

	void setHousehold();

	void setHouseprice();

	void setDentalClinic();

	void setIncome();

	void setSubway();

	void setBus();

	void setResident();

	void setAgeType();

	public void setFloatpp();

	void updatePopulation(ObjectNode obj);

	ArrayList<String> regionCheck();
}
