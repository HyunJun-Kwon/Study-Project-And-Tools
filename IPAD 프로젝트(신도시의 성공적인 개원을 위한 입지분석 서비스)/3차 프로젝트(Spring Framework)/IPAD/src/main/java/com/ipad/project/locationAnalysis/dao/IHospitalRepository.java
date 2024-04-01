package com.ipad.project.locationAnalysis.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.locationAnalysis.model.HospitalCountVO;
@Repository
public interface IHospitalRepository {
	ArrayList<HospitalCountVO> getHospitalCount(int year);
    ArrayList<HospitalDetailVO> getHospitalData();
    void saveRecord(JsonNode record) throws SQLException;
    ArrayList<String> getSigunNm();
    void updateData(JsonNode record) throws SQLException;
}
