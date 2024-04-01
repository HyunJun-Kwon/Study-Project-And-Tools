package com.ipad.project.saleAnalysis.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.saleAnalysis.model.UpdateDataRepositoryParameter;
import com.ipad.project.saleAnalysis.model.UpdateRegionDataVO;

public interface IUpdateDataService {
	
	public void updateRegionDatas();
	
	public void InsertTotalData();
	public String fetchDataFromAPI(String code, int age) throws IOException;
	public JsonNode parseJsonData(String jsonData) throws IOException;
	public void setAgeType();
	public Map<String,Object> convertJsonNodeToMap(JsonNode jsonNode);
	
	public ArrayList<UpdateRegionDataVO> getRegionDataVO();
	public void insertData(UpdateDataRepositoryParameter parameter);
	public void updateData(UpdateDataRepositoryParameter parameter);
	public int getRecordNum();
	public ArrayList<String> selectAdm();
	public void setHouseHold();
	public void setHousePrice();
	public void setDentalClinic();
	public void setIncome();
	public void setSubway();
	public void setBus();
	public void setResident();
	public void setFloatPp();
}
