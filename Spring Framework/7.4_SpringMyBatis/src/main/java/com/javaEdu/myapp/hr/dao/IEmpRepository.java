package com.javaEdu.myapp.hr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.javaEdu.myapp.hr.model.EmpVO;

public interface IEmpRepository {
   int getEmpCount();
   int getEmpCount(@Param("deptid") int deptid);
   List<EmpVO> getEmpList();
   EmpVO getEmpInfo(int empid);
   void updateEmp(EmpVO emp);
   void insertEmp(EmpVO emp);
   void deleteJobHistory(int empid);
   void deleteEmp(@Param("empid") int empid,@Param("email") String email);
   List<Map<String, Object>> getAllDeptId();
   List<Map<String, Object>> getAllJobId();
   List<Map<String, Object>> getAllManagerId();
}