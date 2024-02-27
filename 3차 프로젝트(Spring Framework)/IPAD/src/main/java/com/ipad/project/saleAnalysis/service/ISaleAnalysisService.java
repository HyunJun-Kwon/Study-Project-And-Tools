package com.ipad.project.saleAnalysis.service;

import java.util.List;

import com.ipad.project.saleAnalysis.model.PatientPointVO;
import com.ipad.project.saleAnalysis.model.RegionDataVO;
import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;

public interface ISaleAnalysisService {
	List<SaleOverlayVO> getOverlay();
	List<SaleCalculateVO> getRecommandData(String regionCode);
	List<RegionDataVO> getRegionData(String regionCode);
	List<PatientPointVO> getPatientPoint(String regionCode);
	int patient(String regionCode);
	int employee(int patient);
	int areaSize(int patient);
}
