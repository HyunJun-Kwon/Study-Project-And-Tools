package com.myhome.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myhome.myapp.homeBoard.model.HomeBoardVO;
import com.myhome.myapp.homeBoard.service.IHomeBoardService;

@Controller
public class FrontController {
	
	@Autowired
	IHomeBoardService homeBoardService;
	
	@GetMapping(value="/")
	public String homeCommand(Model model) {
		List<HomeBoardVO> list = homeBoardService.list();
		model.addAttribute("homeList", list);
		return "home";
	}
}
