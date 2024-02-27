package com.javaEdu.myapp.hr;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.javaEdu.myapp.hr.model.EmpVO;
import com.javaEdu.myapp.hr.service.IEmpService;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("spring/application-config.xml");
		IEmpService empService = context.getBean("empService", IEmpService.class);
		
		System.out.print("-- 전체 사원의 수 조회 : ");
		System.out.println(empService.getEmpCount());
		System.out.print("-- 부서가 50인 사원의 수 조회 : ");
		System.out.println(empService.getEmpCount(50));
		
		System.out.println("--103번 사원의 정보를 조회합니다.");
		System.out.println(empService.getEmpInfo(103));
		
		System.out.println("-- 사원 전체 정보를 조회합니다.");
		System.out.println(empService.getEmpList());
		
		System.out.println("-- 새로운 사원 정보를 입력합니다.");
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(230);
		emp.setFirstName("gilDDong");
		emp.setLastName("kwon");
		emp.setEmail("honghong@gmail.com");
		emp.setPhoneNumber("222-222");
		emp.setJobId("IT_PROG");
		emp.setSalary(8000);
		emp.setCommissionPct(0.2);
		emp.setManagerId(100);
		emp.setDepartmentId(10);
		try {
			empService.insertEmp(emp);
			System.out.println("insert ok");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("여기서 안됨");
		}
		
		System.out.println("--신규 사원의 정보를 조회/출력 합니다.");
		EmpVO emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		
		context.close();
	}
}
