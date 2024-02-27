package com.ipad.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherServlet {
	
	@Autowired
	IController controller;
	
	@RequestMapping(value="project/SaleAnalysis")
	public void saleAnalysisController(Model model) {
		controller = new SalaAnalysisController();
		controller.viewCommend(model);
	}
	
	@RequestMapping(value="project/index")
	public String viewMain(Model model) {
		return "main";
	}
}
