package com.ipad.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;
import com.ipad.project.saleAnalysis.service.ISaleAnalysisService;

@Controller
public class SalaAnalysisController implements IController{
	
	@Autowired
	ISaleAnalysisService saleAnalysisService;

	@RequestMapping(value="/saleAnalysis/search")
	public String viewCommend(Model model) {
		System.out.println("search 화면 실행 @@");
		return "saleAnalysis/search";
	}
	
	@GetMapping(value ="/saleAnalysis/customOverlay")
	public @ResponseBody List<SaleOverlayVO> getOverlay(Model model) {
		System.out.println("Overlay 실행 @@");
		List<SaleOverlayVO> overlay = saleAnalysisService.getOverlay();
		return overlay;
	}
	
	@GetMapping("/saleAnalysis/calculate")
	public @ResponseBody List<SaleCalculateVO> getRecommandData(@PathVariable String regionCode, Model model) {
		System.out.println("calutate 실행 @@@@@@@@@");
		System.out.println(regionCode);
		List<SaleCalculateVO> saleCalculate = saleAnalysisService.getRecommandData(regionCode);
		return saleCalculate;
	}
}
