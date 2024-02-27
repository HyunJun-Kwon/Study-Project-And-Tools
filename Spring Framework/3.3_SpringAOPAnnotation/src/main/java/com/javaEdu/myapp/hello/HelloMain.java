package com.javaEdu.myapp.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.javaEdu.myapp.hello.controller.HelloController;

public class HelloMain {

	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");
		HelloController controller = context.getBean("helloController",HelloController.class);
		controller.hello("Eric");
		System.out.println();
		controller.hello("Dan");
		context.close();
	}
}
