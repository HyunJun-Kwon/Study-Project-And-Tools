package com.ipad.project.getRegionData.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.getRegionData.dao.IGetRegionDataRepository;
import com.ipad.project.getRegionData.model.CalSaleVO;
import com.ipad.project.getRegionData.model.GetRegionDataVO;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.getRegionData.model.PatientPointVO;
import com.ipad.project.getRegionData.model.SalePointVO;

@Service
public class GetRegionDataService implements IGetRegionDataService {

	@Autowired
	IGetRegionDataRepository getRegionDataRepository;

	@Override
	public List<HospitalDetailVO> getHospitalData() {
		return getRegionDataRepository.getHospitalData();
	}

	@Override
	public GetRegionDataVO regionInfo(String adm_nm) {
		String adm_cd = getRegionCode(adm_nm);
		return calNetProfit(adm_cd);
	}

	@Override
	public int calEmploymentAvgFee(String adm_cd) {
		return getRegionDataRepository.calEmploymentAvgFee(adm_cd) / 12 * 10000;
	}

	@Override
	public int calRentFee(String adm_cd, String areaSize) {

		int size = Integer.parseInt(areaSize);
		return getRegionDataRepository.calRentFee(adm_cd) * size;

	}

	@Override
	public GetRegionDataVO calNetProfit(String adm_cd) {

		int patient = patientCal(adm_cd);
		int employee = employeeCal(patient);
		int size = areaSizeCal(patient);
		int rentFee = calRentFee(adm_cd, Integer.toString(size));
		int wage = calEmploymentAvgFee(adm_cd);
		int sale = calculateSale(adm_cd);
		int netProfit = sale - rentFee - wage * employee;
		return new GetRegionDataVO(patient, employee, size, sale, netProfit);
	}

	@Override
	public String getRegionCode(String regionName) {
		return getRegionDataRepository.getRegionCode(regionName);
	}

	@Override
	public int calculateSale(String adm_cd) {
		SalePointVO salePoint = getSaleWeight();
		CalSaleVO calSale = getVariableSale(adm_cd);
		if (calSale.getSubway() != 0) {
			return (int) Math
					.round(salePoint.getConstant() + Math.log10(calSale.getTwenties()) * salePoint.getTwentiesPoint()
							+ Math.log10(calSale.getThirties()) * salePoint.getThirtiesPoint()
							+ Math.log10(calSale.getSixties()) * salePoint.getSixtiesPoint()
							+ Math.log10(calSale.getOver70s()) * salePoint.getOver70sPoint()
							+ Math.log10(calSale.getFloatPp()) * salePoint.getFloatPoint()
							+ Math.log10(calSale.getIncome()) * salePoint.getIncomePoint()
							+ Math.log10(calSale.getDentalClinic()) * salePoint.getDentalClinicPoint()
							+ Math.log10(calSale.getSubway()) * salePoint.getSubwayPoint())
					/ (calSale.getDentalClinic() + 1);
		} else {
			return (int) Math
					.round(salePoint.getConstant() + Math.log10(calSale.getTwenties()) * salePoint.getTwentiesPoint()
							+ Math.log10(calSale.getThirties()) * salePoint.getThirtiesPoint()
							+ Math.log10(calSale.getSixties()) * salePoint.getSixtiesPoint()
							+ Math.log10(calSale.getOver70s()) * salePoint.getOver70sPoint()
							+ Math.log10(calSale.getFloatPp()) * salePoint.getFloatPoint()
							+ Math.log10(calSale.getIncome()) * salePoint.getIncomePoint()
							+ Math.log10(calSale.getDentalClinic()) * salePoint.getDentalClinicPoint()
							+ calSale.getSubway() * salePoint.getSubwayPoint())
					/ (calSale.getDentalClinic() + 1);
		}

	}

	@Override
	public SalePointVO getSaleWeight() {
		return getRegionDataRepository.getSaleWeight();
	}

	@Override
	public int areaSizeCal(int patient) {

		if ((int) Math.round(((double) patient / 30) * 1.56) < 15) {
			return 15;
		} else {
			return (int) Math.round(((double) patient / 30) * 1.56);
		}
	}

	@Override
	public int employeeCal(int patient) {
		patient = (int) Math.round(patient / 30.0);
		return (int) Math.ceil(((double) patient / 12) / 2.5) + 1;
	}

	@Override
	public int patientCal(String adm_cd) {
		int patient = 0;
		for (Map<String, Object> map : getRegionDataRepository.patientCal(adm_cd)) {
			patient = (int) (getPatientWeight().getConstant()
					+ Math.log10(Integer.valueOf(String.valueOf(map.get("POPULATION"))))
							* getPatientWeight().getPopulation_point()
					+ Math.log10(Integer.valueOf(String.valueOf(map.get("FLOATPP"))))
							* getPatientWeight().getFloat_point()
					+ Math.log10(Integer.valueOf(String.valueOf(map.get("INCOME"))))
							* getPatientWeight().getIncome_point()
					+ Math.log10(Integer.valueOf(String.valueOf(map.get("DENTALCLINIC"))))
							* getPatientWeight().getDentist_point())
					/ Integer.valueOf(String.valueOf(map.get("DENTALCLINIC")));
			return patient;
		}
		return patient;
	}

	@Override
	public PatientPointVO getPatientWeight() {

		return getRegionDataRepository.getPatientWeight();
	}

	@Override
	public CalSaleVO getVariableSale(String adm_cd) {
		return getRegionDataRepository.getVariableSale(adm_cd);
	}


}
