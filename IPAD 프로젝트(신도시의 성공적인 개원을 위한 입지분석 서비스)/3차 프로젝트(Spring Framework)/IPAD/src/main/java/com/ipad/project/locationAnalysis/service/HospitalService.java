package com.ipad.project.locationAnalysis.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.locationAnalysis.dao.IHospitalRepository;
import com.ipad.project.locationAnalysis.dao.IOpenCloseCountRepository;
import com.ipad.project.locationAnalysis.dao.IResidentPopulationRepository;
import com.ipad.project.locationAnalysis.model.HospitalCountVO;
import com.ipad.project.locationAnalysis.model.HospitalPopulationVO;
import com.ipad.project.locationAnalysis.model.ResidentPopulationVO;

@Service
public class HospitalService implements IHospitalService {
	
	@Autowired
	IHospitalRepository hospital;
	@Autowired
	IOpenCloseCountRepository openCloseCount;
	@Autowired
	IResidentPopulationRepository residentPopulation;
	
	
	@Override
	   public ArrayList<HospitalCountVO> getHospitalCount() {
	      ArrayList<HospitalCountVO> hospitalCountVOs = new ArrayList<HospitalCountVO>();
	      for (int i = LocalDate.now().getYear() - 4; i <= LocalDate.now().getYear(); i++) {
	         ArrayList<HospitalCountVO> hospitalCountDtos2 = hospital.getHospitalCount(i);
	         for (HospitalCountVO vo : hospitalCountDtos2) {
	            vo.setYear(String.valueOf(i));
	            hospitalCountVOs.add(vo);
	         }
	      }
	      System.out.println(hospitalCountVOs);
	      return hospitalCountVOs;
	   }
	
	@Override
	public ArrayList<HospitalCountVO> getHospitalCount(int year) {
		System.out.println("HOSPITALCOUNT");
		return hospital.getHospitalCount(year);
	}


	@Override
	public ArrayList<HospitalDetailVO> getHospitalData() {
		// TODO Auto-generated method stub
		return hospital.getHospitalData();
	}

	@Override
	public void saveRecord(JsonNode record) throws SQLException {
		// TODO Auto-generated method stub
		hospital.saveRecord(record);
	}

	@Override
	public ArrayList<String> getSigunNm() {
		// TODO Auto-generated method stub
		return hospital.getSigunNm();
	}

	@Override
	public void updateData(JsonNode record) throws SQLException {
		// TODO Auto-generated method stub
		hospital.updateData(record);
	}
	
	@Override
	public ArrayList<HospitalPopulationVO> getHospitalPopulation(){
		ArrayList<HospitalCountVO> totalHospitalVOs = hospital.getHospitalCount(LocalDate.now().getYear());
		ArrayList<ResidentPopulationVO> totalPopulationVOs = residentPopulation.getTotalPopulation();
		ArrayList<HospitalPopulationVO> hospitalPopulationVOs = new ArrayList<>();
		for (HospitalCountVO hospitalCountVO : totalHospitalVOs) {
			for (ResidentPopulationVO residentPopulationVO : totalPopulationVOs) {
				if (hospitalCountVO.getRegion().equals(residentPopulationVO.getRegion_name_detail())) {
					HospitalPopulationVO hospitalPopulationVO = new HospitalPopulationVO();
					hospitalPopulationVO.setRegion(hospitalCountVO.getRegion());
					int populationTotal = Integer.parseInt(residentPopulationVO.getPopulation_total());
					int hospitalCount = Integer.parseInt(hospitalCountVO.getCount());
					if (hospitalCount != 0) {
						hospitalPopulationVO.setPopulation(String.valueOf(populationTotal / hospitalCount));
					} else {
						hospitalPopulationVO.setPopulation("0");
					}
					hospitalPopulationVOs.add(hospitalPopulationVO);
				}
			}
		}
		return hospitalPopulationVOs;
	}
	

}
