package com.ipad.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;
import com.ipad.project.saleAnalysis.service.ISaleAnalysisService;
import com.ipad.project.saleAnalysis.service.ISaleOverlayService;

@Controller
public class SalaAnalysisController{
	
	@Autowired
	ISaleAnalysisService saleAnalysisService;
	
	@Autowired
	ISaleOverlayService saleOverlaySerivce;

	@RequestMapping(value="/saleAnalysis/search")
	public String viewCommand(Model model) {
		return "saleAnalysis/search";
	}
	
	@GetMapping(value ="/saleAnalysis/customOverlay")
	public @ResponseBody List<SaleOverlayVO> getOverlay(Model model) {
		List<SaleOverlayVO> overlay = saleOverlaySerivce.getOverlay();
		return overlay;
	}
	
	
	@GetMapping(value ="/saleAnalysis/calculate/{regionCode}")
	public @ResponseBody List<SaleCalculateVO> getRecommandData(@PathVariable String regionCode) {
		System.out.println(regionCode);
		List<SaleCalculateVO> saleCalculate = saleAnalysisService.getRecommandData(regionCode);
		return saleCalculate;
	}
	
	@PostMapping(value ="/saleAnalysis/netprofit")
	public @ResponseBody List<SaleCalculateVO> getSaleData(@RequestParam("rgCode") String regionCode,
			@RequestParam("arSize") String arSize, @RequestParam("seEmple") String seEmple,
			@RequestParam("juEmple") String juEmple, @RequestParam("deptAm") String deptAm) {
		List<SaleCalculateVO> saleCalculate = saleAnalysisService.getNetProfit(regionCode, arSize, seEmple, juEmple, deptAm);
		return saleCalculate;
	}
}
