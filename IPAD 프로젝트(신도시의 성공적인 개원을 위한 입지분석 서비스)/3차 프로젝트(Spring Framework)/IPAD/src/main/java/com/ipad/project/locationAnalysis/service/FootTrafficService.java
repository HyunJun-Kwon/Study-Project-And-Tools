package com.ipad.project.locationAnalysis.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.locationAnalysis.dao.IFootTrafficRepository;
import com.ipad.project.locationAnalysis.model.FootTrafficVO;
@Service
public class FootTrafficService implements IFootTrafficService {

	@Autowired
	IFootTrafficRepository footTraffic;
	@Override
	public ArrayList<FootTrafficVO> selectFootTrafficData() {
		// TODO Auto-generated method stub
		System.out.println(footTraffic.selectFootTrafficData());
		return footTraffic.selectFootTrafficData();
	}

	@Override
	public void saveRecord(JsonNode record) throws SQLException {
		// TODO Auto-generated method stub
		footTraffic.saveRecord(record);
	}

	@Override
	public void updateData(JsonNode record) throws SQLException {
		// TODO Auto-generated method stub
		footTraffic.updateData(record);
	}

}
