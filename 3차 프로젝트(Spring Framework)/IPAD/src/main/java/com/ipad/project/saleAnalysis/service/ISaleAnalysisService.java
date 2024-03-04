package com.ipad.project.saleAnalysis.service;

import java.util.List;

import com.ipad.project.saleAnalysis.model.PatientPointVO;
import com.ipad.project.saleAnalysis.model.RegionDataVO;
import com.ipad.project.saleAnalysis.model.RegionFeeVO;
import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SalePredictPointVO;

public interface ISaleAnalysisService {
	List<SaleCalculateVO> getRecommandData(String regionCode);
	List<RegionDataVO> getRegionData(String regionCode);
	List<PatientPointVO> getPatientPoint();
	int patient(String regionCode);
	int employee(int patient);
	int areaSize(int patient);
	List<SalePredictPointVO> getSalePredictPoint(String regionCode);
	int salePredict(String regionCode);
	List<RegionDataVO> getSaleRegionData(String regionCode);
	List<RegionFeeVO> getRegionFee(String regionCode);
	int rental_fee(String regionCode, String areaSize);
	int employment_fee(String regionCode, String SeniorEmployeeCount, String juniorEmployeeCount);
	int deptAm(String deptAm);
	int netProfit(String regionCode, String areaSize, String seniorEmployeeCount, String juniorEmployeeCount, String deptAm);
	List<SaleCalculateVO> getNetProfit(String regionCode, String areaSize, String seniorEmployeeCount, String juniorEmployeeCount, String deptAm);
}
