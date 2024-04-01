package com.ipad.project.locationAnalysis.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.locationAnalysis.model.FootTrafficVO;

public interface IFootTrafficService {
	ArrayList<FootTrafficVO> selectFootTrafficData();
	void saveRecord(JsonNode record) throws SQLException;
	void updateData(JsonNode record) throws SQLException;
}
