package com.ipad.project.member.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ipad.project.member.model.MemberVO;

public interface IMemberService {
	int insertMember(String id, String pass1, String email, String name, String tel, String year, String map);
	ModelAndView memberJoinFormCheck(String id, String pass1, String email, String name, String tel, String year, String map);
	int memberIdCheck(String id);
	List<MemberVO> loginPageCheck(String id, String pass1);
	ModelAndView editSearch(String id, String pass, String inputPass);
	boolean editUpdate(String id, String pass1, String email, String name, String tel, String year, String map);
	boolean deleteMember(String id, String pass1);
}
