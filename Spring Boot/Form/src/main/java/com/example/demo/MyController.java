package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "JSP IN Gradle";
	}
	
	@RequestMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("name","홍길동");
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id, @RequestParam("name") String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "test2";
	}
	
	@RequestMapping("/test3")
	public String test3(Member member, Model model) {
		return "test3";
	}
	
	@RequestMapping("/test4/{studentId}/{name}")
	public String getStudent(@PathVariable String studentId, @PathVariable String name, Model model) {
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		return "test4";
	}
}
