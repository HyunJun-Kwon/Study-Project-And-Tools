package com.ipad.project.saleAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.saleAnalysis.dao.ISaleRepository;
import com.ipad.project.saleAnalysis.model.PatientPointVO;
import com.ipad.project.saleAnalysis.model.RegionDataVO;
import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;

@Service
public class SaleAnalysisService implements ISaleAnalysisService{

	@Autowired
	ISaleRepository saleRepository;
	
	@Override
	public List<SaleOverlayVO> getOverlay() {
		return saleRepository.getOverlay();
	}
	
	@Override
	public List<SaleCalculateVO> getRecommandData(String regionCode){
//		List<RegionDataVO> regionData = getRegionData(regionCode);
//		List<PatientPointVO> patientPoint = getPatientPoint(regionCode);
//		List<SaleCalculateVO> infomation = getInfomation(regionData, patientPoint);
		System.out.println("GetRecommandData 실행 @@@@");
		return infomation;
	}
	
	@Override
	public List<RegionDataVO> getRegionData(String regionCode){
		return saleRepository.getRegionData(regionCode);
	}
	
	@Override
	public List<PatientPointVO> getPatientPoint(String regionCode) {
		return saleRepository.getPatientPoint();
	}
	
	@Override
	public int patient(String regionCode) {
		List<RegionDataVO> regionData = getRegionData(regionCode);
		List<PatientPointVO> patientPoint = getPatientPoint(regionCode);
		
		int patient_count = 0;
		for(RegionDataVO region : regionData) {
			for(PatientPointVO patient : patientPoint) {
				patient_count += region.getPopulation() * patient.getPopulation_point();
				patient_count += region.getFloatPp() * patient.getFloat_point();
				patient_count += region.getIncome() * patient.getIncome_point();
				patient_count += region.getDentalclinic() * patient.getDentist_point();
				patient_count += patient.getConstant();
			}
		}
		
		return patient_count;
	}
	
	@Override
	public int employee(int Patient) {
		
	}
}
