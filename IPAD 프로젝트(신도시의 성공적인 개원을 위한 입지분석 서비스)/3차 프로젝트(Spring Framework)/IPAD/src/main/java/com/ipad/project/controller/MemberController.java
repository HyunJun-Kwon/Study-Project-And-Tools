package com.ipad.project.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ipad.project.member.model.MemberVO;
import com.ipad.project.member.service.IMemberService;

@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	
	// 약관동의 page 이동
	@GetMapping(value="/member/assent")
	public String assent() {
		return "member/assent";
	}
	
	// 회원가입 page 이동
	@GetMapping(value="/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	// ID 중복 여부 체크
	@PostMapping(value="/member/idCheck")
	public @ResponseBody String idCheck(@RequestParam("id") String id) {
		int result = memberService.memberIdCheck(id);	
		String jsonResponse = "{\"id\": \"" + id + "\", \"result\": " + result + "}";
		
		return jsonResponse;
	}
	
	// ID 중복 여부 확인 page 이동
	@GetMapping(value="/member/idCheck")
	public String idCheck(@RequestParam("result") String result, @RequestParam("id") String id, Model model) {
		model.addAttribute("result",result);
		model.addAttribute("id",id);
		return "member/idCheck";
	}
	
	//회원가입 성공 여부 
	@PostMapping(value="/member/joinFormCheck")
	public ModelAndView joinFormCheck(@RequestParam("id") String id, @RequestParam("pass1") String pass1, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("tel") String tel, @RequestParam("year") String year, @RequestParam("map") String map) {
		
		ModelAndView modelAndView = memberService.memberJoinFormCheck(id, pass1, email, name, tel, year, map);
		
		return modelAndView;
	}
	
	// LOGIN page 이동
	@GetMapping(value="/member/loginPage")
	public String loginPage() {
		return "member/loginPage";
	}
	
	// LOGIN 실행 성공여부에 따라 page 구분
	@PostMapping(value="/member/loginPageCheck")
	public String loginPageCheck(@RequestParam("id") String id, @RequestParam("pass1") String pass1, HttpServletRequest request, HttpServletResponse response) {
		List<MemberVO> vo = memberService.loginPageCheck(id, pass1);

		if(!vo.isEmpty()) {
			//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", vo);
			response.setContentType("text/html; charset=UTF-8");
			return "main";
		} else {
			//로그인 실패
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('아이디와 비밀번호가 틀렸습니다.');</script>");
				out.flush();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return "member/loginPage";
		}
	}
	
	@GetMapping(value="/member/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("loggedInUser");
		return "main";
	}
	
	@GetMapping(value="/member/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	@GetMapping(value="/member/mypageEdit")
	public String mypageEdit() {
		return "member/mypageEdit";
	}
	
	@PostMapping(value="/member/memberEditCheck")
	public ModelAndView memberEditCheck(@RequestParam("pass1") String pass1, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<MemberVO> memberList = (List<MemberVO>) session.getAttribute("loggedInUser");
		MemberVO memberVO = memberList.get(0);
		
		String id = memberVO.getId();
		String pass = memberVO.getPass1();
		String inputPass = pass1;
		
		ModelAndView model = new ModelAndView();
		
		if(pass.equals(inputPass)) {
			model = memberService.editSearch(id, pass, inputPass);
			return model;
		} else {
			session.setAttribute("editMessage", "비밀번호가 틀렸습니다. 다시 입력해주세요");
			model.setViewName("member/mypageEdit");
			return model;
		}
	}
	
	@PostMapping(value="/member/mypageEditFormCheck")
	public String mypageEditFormCheck(@RequestParam("id") String id, @RequestParam("pass1") String pass1, @RequestParam("email") 
	String email, @RequestParam("name") String name, @RequestParam("tel") String tel, @RequestParam("year") String year, @RequestParam("map") String map, 
	HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<MemberVO> memberList = (List<MemberVO>) session.getAttribute("loggedInUser");
		MemberVO memberVO = memberList.get(0);
		
		String ownPass = memberVO.getPass1();
		
		if(pass1 != null & !pass1.isEmpty()) {
			memberVO.setPass1(pass1);
		} else {
			pass1 = ownPass;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		if(memberService.editUpdate(id, pass1, email, name, tel, year, map)) {
			try {
				
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('회원정보 수정이 완료되었습니다.');</script>");
	            out.flush();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		} else {
	        session.setAttribute("editFormMessage", "회원수정이 실패하였습니다.");
	    }
		return "member/mypage";
	}
	
	@GetMapping(value="/member/mypageExit")
	public String mypageExit() {
		return "member/mypageExit";
	}
	
	@PostMapping(value="/member/mypageExitCheck")
	public String mypageExitCheck(@RequestParam("pass1") String pass1, HttpServletRequest request, HttpServletResponse response) {
		 HttpSession session = request.getSession();
		 List<MemberVO> memberList = (List<MemberVO>) session.getAttribute("loggedInUser");
		 MemberVO memberVO = memberList.get(0);
		 
		 String pass = memberVO.getPass1();
		 String id = memberVO.getId();
		 try {
			 if(pass.equals(pass1)) {
				if(memberService.deleteMember(id, pass1)) {
					session.invalidate();
					session = request.getSession();
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('탈퇴가 완료되었습니다.');</script>");
					out.flush();
					return "main";
				} else {
					return "member/mypageExit";
				}
			 } else {
				 session.setAttribute("exitMessage", "비밀번호가 틀렸습니다. 다시 입력해주세요.");
				 response.setContentType("text/html;charset=UTF-8");
				 return "member/mypageExit";
			 }
		 } catch(Exception e) {
			 e.printStackTrace();
			 return "member/mypageExit";
		 }
		 
	}
	
}
