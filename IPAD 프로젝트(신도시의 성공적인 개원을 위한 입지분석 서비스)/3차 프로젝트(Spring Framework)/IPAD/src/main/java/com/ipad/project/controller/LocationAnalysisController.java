package com.ipad.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipad.project.api.service.IJsonService;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.locationAnalysis.model.FootTrafficVO;
import com.ipad.project.locationAnalysis.model.HospitalCountVO;
import com.ipad.project.locationAnalysis.model.HospitalPopulationVO;
import com.ipad.project.locationAnalysis.model.OpenCloseCountVO;
import com.ipad.project.locationAnalysis.model.PopulationForecastVO;
import com.ipad.project.locationAnalysis.model.RegionSummaryVO;
import com.ipad.project.locationAnalysis.model.ResidentPopulationVO;
import com.ipad.project.locationAnalysis.service.IFootTrafficService;
import com.ipad.project.locationAnalysis.service.IHospitalService;
import com.ipad.project.locationAnalysis.service.IOpenCloseCountService;
import com.ipad.project.locationAnalysis.service.IPopulationForecastService;
import com.ipad.project.locationAnalysis.service.IResidentPopulationService;

@Controller
public class LocationAnalysisController {

	@Autowired
	IHospitalService hospitalService;

	@Autowired
	IOpenCloseCountService openCloseCountService;

	@Autowired
	IPopulationForecastService populationForecastService;

	@Autowired
	IResidentPopulationService residentPopulationService;
	
	@Autowired
	IFootTrafficService footTrafficService;
	
	@Autowired
	IJsonService jsonService;

	@GetMapping(value = "/locationAnalysis/hospital.do")
	public String analyzeHospitalData(Model model) {
		ArrayList<OpenCloseCountVO> openCloseCountVOs = openCloseCountService.getOpenData();
		model.addAttribute("OpenCloseCount", openCloseCountVOs);
		
		ArrayList<HospitalCountVO> hospitalCountVOs = hospitalService.getHospitalCount();
		model.addAttribute("HospitalCount", hospitalCountVOs);

		ArrayList<HospitalPopulationVO> hospitalPopulationVOs = hospitalService.getHospitalPopulation();
		model.addAttribute("HospitalPopulation", hospitalPopulationVOs);
		
		return "locationAnalysis/hospitalStatus";
	}
	@GetMapping(value = "/locationAnalysis/population.do")
	public String populationService(Model model) {
		ArrayList<String> admCds = residentPopulationService.getAdmCode();
		for (String admCd : admCds) {
			ArrayList<ResidentPopulationVO> residentPopulationVOs = residentPopulationService
					.selectPopulationData(admCd);
			model.addAttribute(admCd, residentPopulationVOs);
		}
		
		ArrayList<FootTrafficVO> footTrafficVOs = footTrafficService.selectFootTrafficData();
		model.addAttribute("FootTraffic", footTrafficVOs);
		
		model.addAttribute("admCd", admCds);
		
		ArrayList<PopulationForecastVO> populationForecastVOs = populationForecastService.getPopulation();
		model.addAttribute("PopulationForecast", populationForecastVOs);
		
		return "locationAnalysis/populationStatus";
	}
	@RequestMapping(value = "/locationAnalysis/map.do")
	public String map(Model model) {
		return "locationAnalysis/map";
	}
	@RequestMapping(value = "/json/mapRegion.do")
	public @ResponseBody ArrayList<RegionSummaryVO> ResidentPopulation() {
		System.out.println("@@@@@@@@@@@@@@@");
		ArrayList<RegionSummaryVO> regionSummaryVOs = jsonService.mapRegionData();
		System.out.println(regionSummaryVOs);
		return regionSummaryVOs;
	}
	@RequestMapping(value = "/json/map.do")
	public @ResponseBody ArrayList<HospitalDetailVO> mapData() {
		ArrayList<HospitalDetailVO> hospitalDetailVOs = jsonService.mapData();
		return hospitalDetailVOs;
	}
	@RequestMapping(value = "/json/hospital.do")
	public @ResponseBody ArrayList<OpenCloseCountVO> hospitalChart(){
		ArrayList<OpenCloseCountVO> openCloseCountVOs = jsonService.hospitalChart();
		return openCloseCountVOs;
	}
	@RequestMapping(value = "/json/residentPopulation.do")
	public @ResponseBody ArrayList<ResidentPopulationVO> residentPopulationChart(){
		ArrayList<ResidentPopulationVO> residentPopulationVOs = jsonService.residentPopulationChart();
		return residentPopulationVOs;
	}
	
	
	
	
	
	
}
