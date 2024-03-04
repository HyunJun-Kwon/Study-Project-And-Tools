package com.ipad.project.saleAnalysis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.saleAnalysis.dao.ISaleRepository;
import com.ipad.project.saleAnalysis.model.PatientPointVO;
import com.ipad.project.saleAnalysis.model.RegionDataVO;
import com.ipad.project.saleAnalysis.model.RegionFeeVO;
import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SalePredictPointVO;

@Service
public class SaleAnalysisService implements ISaleAnalysisService {

	@Autowired
	ISaleRepository saleRepository;

	@Override
	public List<SaleCalculateVO> getRecommandData(String regionCode) {
		int patientCount = patient(regionCode);
		int areaSizeCount = areaSize(patientCount);
		int employeeCount = employee(patientCount);

		SaleCalculateVO saleCalculateVO = new SaleCalculateVO(areaSizeCount, employeeCount);

		List<SaleCalculateVO> result = new ArrayList<>();
		result.add(saleCalculateVO);
		System.out.println("GetRecommandData 실행 @@@@");
		return result;
	}
	
	@Override
	public List<SaleCalculateVO> getNetProfit(String regionCode, String areaSize, String seniorEmployeeCount, String juniorEmployeeCount, String deptAm) {
		int predictSale = salePredict(regionCode);
		int predictPatient = patient(regionCode);
		int rentFee = rental_fee(regionCode, areaSize);
		int employeeFee = employment_fee(regionCode, seniorEmployeeCount, juniorEmployeeCount);
		int deptAmount = deptAm(deptAm);
		int netProfit = netProfit(regionCode, areaSize, seniorEmployeeCount, juniorEmployeeCount, deptAm);
		
		SaleCalculateVO saleCalculateVO = new SaleCalculateVO(predictSale, predictPatient, rentFee, employeeFee, deptAmount, netProfit);
		
		List<SaleCalculateVO> result = new ArrayList<>();
		
		System.out.println("GetNetProfit 메소드 실행 @@@@");
		
		result.add(saleCalculateVO);
		
		return result;
	}

	@Override
	public List<RegionDataVO> getRegionData(String regionCode) {
		return saleRepository.getRegionData(regionCode);
	}

	@Override
	public List<PatientPointVO> getPatientPoint() {
		return saleRepository.getPatientPoint();
	}
	
	@Override
	public List<RegionDataVO> getSaleRegionData(String regionCode) {
		return saleRepository.getSaleRegionData(regionCode);
	}
	
	@Override
	public int patient(String regionCode) {
		List<RegionDataVO> regionData = getRegionData(regionCode);
		List<PatientPointVO> patientPoint = getPatientPoint();

		int patient_count = 0;
	    RegionDataVO region = regionData.get(0); // 해당 지역 데이터
	    PatientPointVO patient = patientPoint.get(0); // 환자 포인트는 모든 지역에 대한 것이므로 첫 번째 것을 사용

	    patient_count = (int)((int) Math.round(patient.getConstant()
	    + Math.log10(region.getPopulation()) * patient.getPopulation_point()
	    + Math.log10(region.getFloatPp()) * patient.getFloat_point()
	    + Math.log10(region.getPopulation()) * patient.getIncome_point()
	    + Math.log10(region.getDentalclinic()) * patient.getDentist_point())/region.getDentalclinic());

	    return patient_count;
	}

	@Override
	public int employee(int patient) {
		patient = (int) Math.round(patient / 30.0);
		int employee = 0;
		employee = (int) Math.ceil(((double) patient / 12) / 2.5) + 1;
		
		return employee;
	}

	@Override
	public int areaSize(int patient) {
		int areaSize = 0;
		areaSize = (int) Math.round(((double) patient / 30) * 1.56);
		if (areaSize < 15) {
			areaSize = 15;
		}
		return areaSize;
	}
	
	@Override
	public List<SalePredictPointVO> getSalePredictPoint(String regionCode) {
		return saleRepository.getSalePredictPoint();
	}
	
	@Override
	public int salePredict(String regionCode) {
		List<RegionDataVO> saleRegionData = getSaleRegionData(regionCode);
		List<SalePredictPointVO> salePoint = getSalePredictPoint(regionCode);
		
		int salePd = 0;
		RegionDataVO region = saleRegionData.get(0); // 해당 지역 데이터
		SalePredictPointVO sale = salePoint.get(0);
		
		System.out.println("지하철 수 : " + region.getSubway());
		System.out.println("20대 : " + region.getTwenties());
		
		if(region.getSubway() != 0) {
			salePd = (int) Math.round((sale.getConstant()
					+ Math.log10(region.getTwenties()) * sale.getPopulation_20_point()
					+ Math.log10(region.getThirties()) * sale.getPopulation_30_point()
					+ Math.log10(region.getSixties()) * sale.getPopulation_60_point()
					+ Math.log10(region.getOver70s()) * sale.getPopulation_over70_point()
					+ Math.log10(region.getFloatPp()) * sale.getFloatPp_point()
					+ Math.log10(region.getIncome()) * sale.getIncome_point()
					+ Math.log10(region.getDentalclinic()) * sale.getDentalClinic_point()
					+ Math.log10(region.getSubway()) * sale.getSubway_point()) / (region.getDentalclinic() +1));
		} else {
			salePd = (int) Math.round((sale.getConstant()
					+ Math.log10(region.getTwenties()) * sale.getPopulation_20_point()
					+ Math.log10(region.getThirties()) * sale.getPopulation_30_point()
					+ Math.log10(region.getSixties()) * sale.getPopulation_60_point()
					+ Math.log10(region.getOver70s()) * sale.getPopulation_over70_point()
					+ Math.log10(region.getFloatPp()) * sale.getFloatPp_point()
					+ Math.log10(region.getIncome()) * sale.getIncome_point()
					+ Math.log10(region.getDentalclinic()) * sale.getDentalClinic_point()
					+ region.getSubway() * sale.getSubway_point()) / (region.getDentalclinic() +1));
		}
		System.out.println("예상매출  : " + salePd);
		return salePd;
	}
	
	@Override 
	public List<RegionFeeVO> getRegionFee(String regionCode) {
		return saleRepository.getRegionFee(regionCode);
	}
	
	@Override
	public int rental_fee(String regionCode, String areaSize) {
		List<RegionFeeVO> regionFee = getRegionFee(regionCode);
		RegionFeeVO region = regionFee.get(0);
		
		int rental = 0;
		rental = region.getRent_per() * Integer.parseInt(areaSize);
		
		System.out.println("임대료 : " + rental);
		return rental;
	}
	
	@Override
	public int employment_fee(String regionCode, String seniorEmployeeCount, String juniorEmployeeCount) {
		List<RegionFeeVO> regionFee = getRegionFee(regionCode);
		RegionFeeVO region = regionFee.get(0);
		
		int employment = 0;
		employment = (region.getOver_ten_year()*1000) * Integer.parseInt(seniorEmployeeCount) + (region.getUnder_three_year()*1000) * Integer.parseInt(juniorEmployeeCount);
		
		System.out.println("직원 임금 : " + employment);
		return employment;
	}
	
	@Override
	public int deptAm(String deptAm) {
		int deptAmount = Integer.parseInt(deptAm) * 10000;
		System.out.println("deptAm 메소드 실행 @@@@ " +" 이자 : " + deptAmount);
		return deptAmount;
	}
	
	@Override
	public int netProfit(String regionCode,String areaSize,String seniorEmployeeCount, String juniorEmployeeCount, String deptAm) {
		int saleAmount = salePredict(regionCode);
		int rental = rental_fee(regionCode, areaSize);
		int employment = employment_fee(regionCode, seniorEmployeeCount, juniorEmployeeCount);
		int deptAmount = deptAm(deptAm);
		
		int netPro = saleAmount - rental - employment - deptAmount;
		System.out.println("netProfit 메소드 실행 @@@@ " + "순수익 : " + netPro);
		return netPro;
	}
	
	
}
