package com.ipad.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipad.project.board.model.BoardVo;
import com.ipad.project.board.service.IBoardService;

@Controller
public class BoardController {

	@Autowired
	IBoardService boardService;

	@GetMapping("/board/boardList.do")
	public ModelAndView list(@RequestParam("pageNum") String pageNum) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/boardList");
		mv.addObject("list", boardService.list(pageNum));
		mv.addObject("count", boardService.count());
		mv.addObject("currentPage", Integer.parseInt(pageNum));
		mv.addObject("pageSize", 10);

		return mv;
	}

	@RequestMapping("/board/boardListWriteClickAction.do")
	public String write(Model model) {
		return "/board/boardWrite";
	}

	@PostMapping("/board/boardWriteCheck.do")
	public String writeCheck(BoardVo board, Model model) {
		boardService.write(board);
		return "redirect:/board/boardList.do?pageNum=1";
	}

	@GetMapping("/board/boardWriteViewCheck.do")
	public ModelAndView view(@RequestParam("num") int num, Model model) {
		boardService.readCount(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardService.view(num));
		mv.addObject("count", boardService.replyCount(num));
		mv.addObject("replyList", boardService.replyList(String.valueOf(num)));
		mv.setViewName("/board/boardWriteView");
		return mv;
	}

	@PostMapping("/board/boardWriteDelete.do")
	public String deleteBoard(@RequestParam("num") String num, @RequestParam("password") String password) {
		boardService.delete(num);
		return "redirect:/board/boardList.do?pageNum=1";
	}

	@GetMapping("/board/boardWriteEdit.do")
	public String edit(@RequestParam("num") int num, Model model) {
		model.addAttribute("list", boardService.view(num));
		return "/board/boardWriteUpdate";
	}

	@PostMapping("/board/boardWriteUpdateCheck.do")
	public String updateCheck(BoardVo board, Model model) {
		boardService.edit(board);
		return "redirect:/board/boardList.do?pageNum=1";
	}

	@PostMapping("/board/boardReWriter.do")
	public String rewrite(@RequestParam("replyText") String text, @RequestParam("num") String num, Model model) {
		boardService.reply(text, num);
//		model.addAttribute("replyList", boardService.replyList(num));
		return "redirect:/board/boardWriteViewCheck.do?num=" + num;
	}
}
