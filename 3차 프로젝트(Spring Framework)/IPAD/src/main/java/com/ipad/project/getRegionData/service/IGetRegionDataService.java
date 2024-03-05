package com.ipad.project.getRegionData.service;

import java.util.List;

import com.ipad.project.getRegionData.model.CalSaleVO;
import com.ipad.project.getRegionData.model.GetRegionDataVO;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.getRegionData.model.PatientPointVO;
import com.ipad.project.getRegionData.model.SalePointVO;

public interface IGetRegionDataService {
	List<HospitalDetailVO> getHospitalData();

	GetRegionDataVO regionInfo(String adm_nm);

	int calEmploymentAvgFee(String adm_cd);

	int areaSizeCal(int patient);

	int employeeCal(int patient);

	int patientCal(String adm_cd);

	int calculateSale(String adm_cd);

	int calRentFee(String adm_cd, String areaSize);

	String getRegionCode(String regionName);

	GetRegionDataVO calNetProfit(String adm_cd);

	SalePointVO getSaleWeight();

	PatientPointVO getPatientWeight();

	CalSaleVO getVariableSale(String adm_cd);

}
