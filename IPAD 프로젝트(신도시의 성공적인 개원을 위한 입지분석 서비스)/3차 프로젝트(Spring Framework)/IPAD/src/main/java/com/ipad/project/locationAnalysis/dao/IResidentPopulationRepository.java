package com.ipad.project.locationAnalysis.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.locationAnalysis.model.ResidentPopulationVO;
@Repository
public interface IResidentPopulationRepository {
	ArrayList<ResidentPopulationVO> getTotalPopulation();
    ArrayList<ResidentPopulationVO> getAgeGroup();
    ArrayList<ResidentPopulationVO> selectPopulationData(String admCd);
    void saveRecord(JsonNode record, String year, String option) throws SQLException;
    ArrayList<String> getAdmCode();
    void UpdateData(JsonNode record, String year, String option) throws SQLException;
    String getRecentYear();
}
