package com.javaEdu.myapp.hello.controller;

import com.javaEdu.myapp.hello.service.IHelloService;

public class HelloController {
	IHelloService helloService;
	
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
	}
}
