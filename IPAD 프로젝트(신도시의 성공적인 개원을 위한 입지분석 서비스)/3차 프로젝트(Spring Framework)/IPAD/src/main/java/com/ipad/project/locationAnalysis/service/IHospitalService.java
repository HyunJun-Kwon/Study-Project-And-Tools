package com.ipad.project.locationAnalysis.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.locationAnalysis.model.HospitalCountVO;
import com.ipad.project.locationAnalysis.model.HospitalPopulationVO;

public interface IHospitalService {
	ArrayList<HospitalCountVO> getHospitalCount();
    ArrayList<HospitalDetailVO> getHospitalData();
    void saveRecord(JsonNode record) throws SQLException;
    ArrayList<String> getSigunNm();
    void updateData(JsonNode record) throws SQLException;
	ArrayList<HospitalCountVO> getHospitalCount(int year);
	ArrayList<HospitalPopulationVO> getHospitalPopulation();

}
