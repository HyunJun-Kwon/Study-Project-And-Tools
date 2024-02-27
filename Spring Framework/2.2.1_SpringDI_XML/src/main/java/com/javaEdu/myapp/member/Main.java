package com.javaEdu.myapp.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		
		Customer cust = context.getBean(Customer.class);
		System.out.println(cust);
		context.close();
	}
}
