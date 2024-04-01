package com.ipad.project.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ipad.project.member.dao.IMemberRepository;
import com.ipad.project.member.model.MemberVO;

@Service
public class MemberService implements IMemberService{
	@Autowired
	IMemberRepository memberRepository;
	
	@Override
	public int insertMember(String id, String pass1, String email, String name, String tel, String year, String map) {
		
		try {
		memberRepository.insertMember(id, pass1, email, name, tel, year, map);
		return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//ModelAndView에 이동할 view와 가지고 갈 messge와 name을 추가
	@Override
	public ModelAndView memberJoinFormCheck(String id, String pass1, String email, String name, String tel, String year, String map) {
		int checkNum = insertMember(id,pass1,email,name,tel,year,map);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(checkNum == 1) {
			modelAndView.setViewName("member/joinFinish");
			modelAndView.addObject("messge", "회원가입이 완료되었습니다.");
			modelAndView.addObject("name", name);
		} else {
			modelAndView.setViewName("member/joinFinish");
			modelAndView.addObject("messge", "회원가입에 실패하였습니다.");
		}
		
		return modelAndView;
	}

	@Override
	public int memberIdCheck(String id) {
		List<MemberVO> idList = memberRepository.confirmId(id);
		if(idList.isEmpty()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	//로그인할때 id pass1으로 아이디 비밀번호 확인 후 id, pass1, name 3가지를 MemberVO에 매핑
	@Override
	public List<MemberVO> loginPageCheck(String id, String pass1) {
		List<MemberVO> memberVO = memberRepository.loginCheck(id, pass1);
		return memberVO;
	}
	
	//회원정보 수정 시 session의 id, pass를 session에서 받고 requestParam에서 입력한 inputPass를 받아와서 실행(inputPass는 사용 X)
	@Override
	public ModelAndView editSearch(String id, String pass, String inputPass) {
		List<MemberVO> memberList = memberRepository.editSearch(id, pass);
		MemberVO vo = memberList.get(0);
		ModelAndView modelAndView = new ModelAndView();
		// ModelAndView에 이동할 View와 가지고갈 Data 추가 jsp에서 ${id} 하면 vo.getId()값이 들어감.
			modelAndView.addObject("id", vo.getId());
			modelAndView.addObject("pass1", vo.getPass1());
			modelAndView.addObject("email",vo.getEmail());
			modelAndView.addObject("name",vo.getName());
			modelAndView.addObject("tel",vo.getTel());
			modelAndView.addObject("year",vo.getYear());
			modelAndView.addObject("map",vo.getMap());
			modelAndView.setViewName("member/mypageEditForm");
		
		return modelAndView;
	}
	
	@Override
	public boolean editUpdate(String id, String pass1, String email, String name, String tel, String year, String map) {
		try {
			memberRepository.editUpdate(id, pass1, email, name, tel, year, map);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteMember(String id, String pass1) {
		try {
			memberRepository.deleteMember(id, pass1);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
