package com.ipad.project.locationAnalysis.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.locationAnalysis.model.FootTrafficVO;

@Repository
public interface IFootTrafficRepository {
	ArrayList<FootTrafficVO> selectFootTrafficData();
	void saveRecord(JsonNode record) throws SQLException;
	void updateData(JsonNode record) throws SQLException;
	
}
