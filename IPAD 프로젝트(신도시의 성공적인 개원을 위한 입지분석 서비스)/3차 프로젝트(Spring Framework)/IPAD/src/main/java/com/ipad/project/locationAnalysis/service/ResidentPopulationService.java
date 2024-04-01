package com.ipad.project.locationAnalysis.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.locationAnalysis.dao.IResidentPopulationRepository;
import com.ipad.project.locationAnalysis.model.ResidentPopulationVO;
@Service
public class ResidentPopulationService implements IResidentPopulationService {
	@Autowired
	IResidentPopulationRepository rpr;
	
	@Override
	public ArrayList<ResidentPopulationVO> getTotalPopulation() {
		// TODO Auto-generated method stub
		return rpr.getTotalPopulation();
	}

	@Override
	public ArrayList<ResidentPopulationVO> getAgeGroup() {
		// TODO Auto-generated method stub
		return rpr.getAgeGroup();
	}

	@Override
	public ArrayList<ResidentPopulationVO> selectPopulationData(String admCd) {
		// TODO Auto-generated method stub
		return rpr.selectPopulationData(admCd);
	}

	@Override
	public void saveRecord(JsonNode record, String year, String option) throws SQLException {
		// TODO Auto-generated method stub
		rpr.saveRecord(record, year, option);
	}

	@Override
	public ArrayList<String> getAdmCode() {
		// TODO Auto-generated method stub
		return rpr.getAdmCode();
	}

	@Override
	public void UpdateData(JsonNode record, String year, String option) throws SQLException {
		// TODO Auto-generated method stub
		rpr.UpdateData(record, year, option);
	}

	@Override
	public String getRecentYear() {
		// TODO Auto-generated method stub
		return rpr.getRecentYear();
	}

}
