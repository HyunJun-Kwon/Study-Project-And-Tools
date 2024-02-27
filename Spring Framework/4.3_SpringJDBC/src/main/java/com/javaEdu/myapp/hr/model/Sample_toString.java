package com.javaEdu.myapp.hr.model;

public class Sample_toString {
	public static void main(String[] args) {
		It a = new It();
		System.out.println(a);
	}
}

class It{
	@Override
	public String toString() {
		return "Print for Object Information.!!!";
	}
}
