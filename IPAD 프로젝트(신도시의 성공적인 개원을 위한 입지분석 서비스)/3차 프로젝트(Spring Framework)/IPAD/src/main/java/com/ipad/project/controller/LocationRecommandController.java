package com.ipad.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipad.project.getRegionData.model.GetRegionDataVO;
import com.ipad.project.getRegionData.model.HospitalDetailVO;
import com.ipad.project.getRegionData.service.IGetRegionDataService;
import com.ipad.project.locationRecommand.model.RecommandVO;
import com.ipad.project.locationRecommand.service.IRecommandService;

@Controller
public class LocationRecommandController{

		@Autowired
		IRecommandService recommandService;
		
		@Autowired
		IGetRegionDataService getRegionDataService;
	
		@GetMapping(value="/locationRecommand/recommand")
		public String viewRecommand(Model model) {
			return "locationRecommand/recommand";	
		}
		
		@PostMapping(value ="/json/locationRecommand")
		public @ResponseBody List<RecommandVO>  getRegionList(@RequestBody Map<String, Boolean> data, Model model) {
			boolean opt1 = data.get("checkOrth");
			boolean opt2 = data.get("checkImpl");
			List<RecommandVO> recommand = recommandService.recommandRegion(opt1, opt2);
			return recommand;
		}
		
		@PostMapping(value="/json/predict")
		public @ResponseBody GetRegionDataVO predictData(@RequestBody Map<String, String> data,  Model model) {
			String adm_nm = data.get("name");
			GetRegionDataVO recommand = getRegionDataService.regionInfo(adm_nm);
			return recommand;
		}
		
		@GetMapping(value="/json/map")
		public @ResponseBody List<HospitalDetailVO> mapData() {
			List<HospitalDetailVO> hospital = getRegionDataService.getHospitalData();
			return hospital;
		}
		
}
