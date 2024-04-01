package com.ipad.project.api.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.locationAnalysis.dao.IHospitalRepository;
import com.ipad.project.locationAnalysis.dao.IOpenCloseCountRepository;
import com.ipad.project.locationAnalysis.dao.IResidentPopulationRepository;
import com.ipad.project.locationAnalysis.model.HospitalCountVO;
import com.ipad.project.locationAnalysis.model.HospitalPopulationVO;
import com.ipad.project.locationAnalysis.model.OpenCloseCountVO;
import com.ipad.project.locationAnalysis.model.RegionSummaryVO;
import com.ipad.project.locationAnalysis.model.ResidentPopulationVO;
@Service
public class JsonService implements IJsonService {
	@Autowired
	IHospitalRepository hospitalRepository;
	@Autowired
	IResidentPopulationRepository residentPopulationRepository;
	@Autowired
	IOpenCloseCountRepository openCloseCountRepository;

	public ArrayList<RegionSummaryVO> mapRegionData() {
		ArrayList<RegionSummaryVO> regionSummaryVOs = new ArrayList<RegionSummaryVO>();

		// 병원수

		ArrayList<HospitalCountVO> hospitalCountVOs = hospitalRepository.getHospitalCount(LocalDate.now().getYear());
		System.out.println(hospitalCountVOs);
		for (HospitalCountVO vo : hospitalCountVOs) {
			RegionSummaryVO regionSummaryVO = new RegionSummaryVO();
			regionSummaryVO.setRegion(vo.getRegion());
			regionSummaryVO.setHospitalCount(vo.getCount());
			regionSummaryVOs.add(regionSummaryVO);
		}

		// 유동인구
		for (RegionSummaryVO vo : regionSummaryVOs) {
			vo.setFootTraffic("1");
		}

		// 주거인구
		ArrayList<ResidentPopulationVO> residentPopulationVOs = residentPopulationRepository.getTotalPopulation();

		for (int i = 0; i < regionSummaryVOs.size(); i++) {
			for (ResidentPopulationVO vo : residentPopulationVOs) {
				if (regionSummaryVOs.get(i).getRegion().equals(vo.getRegion_name_detail())) {
					RegionSummaryVO tem = regionSummaryVOs.get(i);
					tem.setResidetnPopulation(vo.getPopulation_total());
				}
			}
		}

		// 치과 당 인구
		ArrayList<ResidentPopulationVO> totalPopulationVOs = residentPopulationRepository.getTotalPopulation();
		ArrayList<HospitalPopulationVO> hospitalPopulationVOs = new ArrayList<HospitalPopulationVO>();

		for (HospitalCountVO hospitalCountVO : hospitalCountVOs) {
			for (ResidentPopulationVO residentPopulationVO : totalPopulationVOs) {
				if (hospitalCountVO.getRegion().equals(residentPopulationVO.getRegion_name_detail())) {
					HospitalPopulationVO hospitalPopulationVO = new HospitalPopulationVO();
					hospitalPopulationVO.setRegion(hospitalCountVO.getRegion());
					hospitalPopulationVO
							.setPopulation(String.valueOf(Integer.parseInt(residentPopulationVO.getPopulation_total())
									/ Integer.parseInt(hospitalCountVO.getCount())));
					hospitalPopulationVOs.add(hospitalPopulationVO);
				}
			}
		}

		for (int i = 0; i < regionSummaryVOs.size(); i++) {
			for (HospitalPopulationVO vo : hospitalPopulationVOs) {
				if (regionSummaryVOs.get(i).getRegion().equals(vo.getRegion())) {
					RegionSummaryVO tem = regionSummaryVOs.get(i);
					tem.setHospitalPopulation(vo.getPopulation());
				}
			}
		}

		// 가장많은 연령
		int temp10 = 0;
		int temp20 = 0;
		int temp30 = 0;
		int temp40 = 0;
		int temp50 = 0;
		int temp60 = 0;
		int temp70 = 0;

		ArrayList<ResidentPopulationVO> ageGroupfVOs = residentPopulationRepository.getAgeGroup();
		for (int i = 0; i < regionSummaryVOs.size(); i++) {
			for (ResidentPopulationVO vo : ageGroupfVOs) {
				if (regionSummaryVOs.get(i).getRegion().equals(vo.getRegion_name_detail())) {

					int temp = Integer.parseInt(vo.getPopulation_10());
					String ageGroup = "10대";
					if (temp < Integer.parseInt(vo.getPopulation_20())) {
						temp = Integer.parseInt(vo.getPopulation_20());
						ageGroup = "20대";
					}
					if (temp < Integer.parseInt(vo.getPopulation_30())) {
						temp = Integer.parseInt(vo.getPopulation_30());
						ageGroup = "30대";
					}
					if (temp < Integer.parseInt(vo.getPopulation_40())) {
						temp = Integer.parseInt(vo.getPopulation_40());
						ageGroup = "40대";
					}
					if (temp < Integer.parseInt(vo.getPopulation_50())) {
						temp = Integer.parseInt(vo.getPopulation_50());
						ageGroup = "50대";
					}
					if (temp < Integer.parseInt(vo.getPopulation_60())) {
						temp = Integer.parseInt(vo.getPopulation_60());
						ageGroup = "60대";
					}
					if (temp < Integer.parseInt(vo.getPopulation_70())) {
						temp = Integer.parseInt(vo.getPopulation_70());
						ageGroup = "70대";
					}
					RegionSummaryVO tem = regionSummaryVOs.get(i);
					tem.setMaxAgeGroup(ageGroup);
					regionSummaryVOs.set(i, tem);

					// 전체 계산
					temp10 = temp + Integer.parseInt(vo.getPopulation_10());
					temp20 = temp + Integer.parseInt(vo.getPopulation_20());
					temp30 = temp + Integer.parseInt(vo.getPopulation_30());
					temp40 = temp + Integer.parseInt(vo.getPopulation_40());
					temp50 = temp + Integer.parseInt(vo.getPopulation_50());
					temp60 = temp + Integer.parseInt(vo.getPopulation_60());
					temp70 = temp + Integer.parseInt(vo.getPopulation_70());

				}
			}
		}

		// 전체 인구
		RegionSummaryVO regoinWide = new RegionSummaryVO();
		regoinWide.setRegion("전체");
		for (RegionSummaryVO vo : regionSummaryVOs) {
			if (regoinWide.getHospitalCount().isEmpty()) {
				regoinWide.setHospitalCount(vo.getHospitalCount());
			} else {
				regoinWide.setHospitalCount(String.valueOf(
						Integer.parseInt(vo.getHospitalCount()) + Integer.parseInt(regoinWide.getHospitalCount())));
			}

			if (regoinWide.getFootTraffic().isEmpty()) {
				regoinWide.setFootTraffic(vo.getFootTraffic());
			} else {
				regoinWide.setFootTraffic(String.valueOf(
						Integer.parseInt(vo.getFootTraffic()) + Integer.parseInt(regoinWide.getFootTraffic())));
			}

			if (regoinWide.getResidetnPopulation().isEmpty()) {
				regoinWide.setResidetnPopulation(vo.getResidetnPopulation());
			} else {
				regoinWide.setResidetnPopulation(String.valueOf(Integer.parseInt(vo.getResidetnPopulation())
						+ Integer.parseInt(regoinWide.getResidetnPopulation())));
			}
		}
		System.out.println("오류찾는중");
		System.out.println(regoinWide.getResidetnPopulation()+"이건가");

		int population = Integer.parseInt(regoinWide.getResidetnPopulation());
		int hospitalCount = Integer.parseInt(regoinWide.getHospitalCount());

		regoinWide.setHospitalPopulation(String.valueOf(population / hospitalCount));
		regionSummaryVOs.add(regoinWide);

		int tempTotal = temp10;
		String ageGroup = "10대";
		if (tempTotal < temp20) {
			tempTotal = temp20;
			ageGroup = "20대";
		}
		if (tempTotal < temp30) {
			tempTotal = temp30;
			ageGroup = "30대";
		}
		if (tempTotal < temp40) {
			tempTotal = temp40;
			ageGroup = "40대";
		}
		if (tempTotal < temp50) {
			tempTotal = temp50;
			ageGroup = "50대";
		}
		if (tempTotal < temp60) {
			tempTotal = temp60;
			ageGroup = "60대";
		}
		if (tempTotal < temp70) {
			tempTotal = temp70;
			ageGroup = "70대";
		}
		regoinWide.setMaxAgeGroup(ageGroup);

		return regionSummaryVOs;

	}

	public ArrayList<HospitalDetailVO> mapData() {
		ArrayList<HospitalDetailVO> vos = hospitalRepository.getHospitalData();
		return vos;
	}

	public ArrayList<OpenCloseCountVO> hospitalChart() {
		ArrayList<OpenCloseCountVO> vos = openCloseCountRepository.getOpenData();
		return vos;
	}

	public ArrayList<ResidentPopulationVO> residentPopulationChart() {
		ArrayList<ResidentPopulationVO> vos = new ArrayList<ResidentPopulationVO>();
		ArrayList<String> admCds = residentPopulationRepository.getAdmCode();

		// 전체 데이터를 담을 리스트
		ArrayList<ResidentPopulationVO> allData = new ArrayList<>();

		// 각 지역 코드에 대한 데이터를 전체 데이터에 추가
		for (String admCd : admCds) {
			ArrayList<ResidentPopulationVO> residentPopulationVOsvos = residentPopulationRepository
					.selectPopulationData(admCd);
			allData.addAll(residentPopulationVOsvos);
		}

		return allData;

	}

}
