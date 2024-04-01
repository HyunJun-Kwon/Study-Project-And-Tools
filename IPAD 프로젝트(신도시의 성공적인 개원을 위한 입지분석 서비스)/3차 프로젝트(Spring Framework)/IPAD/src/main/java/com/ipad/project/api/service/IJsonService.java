package com.ipad.project.api.service;

import java.util.ArrayList;

import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.locationAnalysis.model.OpenCloseCountVO;
import com.ipad.project.locationAnalysis.model.RegionSummaryVO;
import com.ipad.project.locationAnalysis.model.ResidentPopulationVO;

public interface IJsonService {
	ArrayList<RegionSummaryVO> mapRegionData();
	ArrayList<HospitalDetailVO> mapData();
	ArrayList<OpenCloseCountVO> hospitalChart();
	ArrayList<ResidentPopulationVO> residentPopulationChart();
	
}
