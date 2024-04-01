package com.ipad.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String viewRecommand() {
		System.out.println("Main @@@@@@@@@@@");
		return "main";
	}
	
	@GetMapping(value = "/main")
	public String viewCommand() {
		System.out.println("logo main @@");
		return "main";
	}
}
