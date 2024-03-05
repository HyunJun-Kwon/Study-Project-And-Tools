package com.ipad.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/project/main")
	public String viewRecommand() {
		System.out.println("Main @@@@@@@@@@@");
		return "redirect:/main";
	}
}
