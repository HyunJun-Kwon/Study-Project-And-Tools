package com.javaEdu.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaEdu.myapp.board.model.BoardCheckVO;
import com.javaEdu.myapp.board.model.BoardVO;
import com.javaEdu.myapp.board.service.IBoardService;

@Controller
public class BoardController {

	@Autowired
	IBoardService boardService;

	@GetMapping(value = "/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("list", boardService.list());

		return mav;
	}

	@GetMapping(value = "/BoardWrite")
	public String write() {
		return "boardWrite";
	}
	
	@PostMapping(value = "/BoardWriteCheck")
	public String writeCheck(BoardVO vo) {
		boardService.write(vo);

		return "redirect:/";
	}
	
	@GetMapping(value = "/BoardView")
	public ModelAndView view(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		boardService.readCount(num);
		
		mav.addObject("list", boardService.view(num));
		mav.setViewName("boardView");
		return mav;
	}
	
	@GetMapping(value = "/BoardDelete")
	public String delete(@RequestParam("num") int num, @RequestParam("password") String password) {
		BoardCheckVO vo = new BoardCheckVO();
		vo.setNum(num);
		vo.setPassword(password);
		
		boardService.delete(vo);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/BoardWriteEdit")
	public ModelAndView edit(@RequestParam("num") int num, @RequestParam("password") String password) {
		BoardCheckVO vo = new BoardCheckVO();
		vo.setNum(num);
		vo.setPassword(password);

		ModelAndView mav = new ModelAndView();
		if(boardService.checkPW(vo)) {
	        List<BoardVO> boardList = boardService.loadEdit(vo);
	        mav.addObject("list", boardList);

	        // 리스트의 각 항목 출력
	        for (BoardVO board : boardList) {
	            System.out.println("Num: " + board.getNum());
	            System.out.println("Writer: " + board.getWriter());
	            System.out.println("Subject: " + board.getSubject());
	            System.out.println("Content: " + board.getContent());
	            // 필요한 다른 속성들도 출력할 수 있습니다.
	        }

	        mav.setViewName("boardWriteUpdate");
	    } else {
	        mav.setViewName("passwordIncorrect");
	    }
		
		return mav;
	}
	
	@PostMapping(value = "/BoardWriteUpdateCheck")
	public String updateCheck(BoardVO board, Model model) {
		System.out.println("@@@@@@@@@@@@@@@@@@");
	    boardService.edit(board);
	    
	    return "redirect:/";
	}
	
}
