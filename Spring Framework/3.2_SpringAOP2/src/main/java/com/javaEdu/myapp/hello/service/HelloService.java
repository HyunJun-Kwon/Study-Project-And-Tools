package com.javaEdu.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() 메서드 실행");
		String message = "Hello ~~~ " + name;
		return message;
	}

	@Override
	public String sayGoodby(String name) {
		String message = "Goodbye~~~" + name;
		System.out.println("HelloService.sayCoodby() 실행");
		if(Math.random()<0.5) {
			throw new RuntimeException("Goodbye Exception");
		}
		return message;
	}
	
	

}
