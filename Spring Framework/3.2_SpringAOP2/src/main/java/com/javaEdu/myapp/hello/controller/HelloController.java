package com.javaEdu.myapp.hello.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.javaEdu.myapp.hello.service.IHelloService;


@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("helloService")
	IHelloService helloService;
	
	public void sayhello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
	}
	
	public void goodbye(String name) {
		System.out.println("HelloController : " + helloService.sayGoodby(name));
	}

}
