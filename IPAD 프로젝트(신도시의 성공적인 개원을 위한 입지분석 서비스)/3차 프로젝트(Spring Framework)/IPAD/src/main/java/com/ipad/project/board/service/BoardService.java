package com.ipad.project.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.board.dao.IBoardRepository;
import com.ipad.project.board.model.BoardVo;

@Service
public class BoardService implements IBoardService{

	@Autowired
	IBoardRepository boardRepository;
	
	@Override
	public void write(BoardVo vo) {
		boardRepository.write(vo);
	}

	@Override
	public void delete(String num) {
		boardRepository.delete(num);		
	}

	@Override
	public void edit(BoardVo vo) {
		boardRepository.edit(vo);
		
	}

	@Override
	public List<BoardVo> list(String pageNum) {
		Map<String, Integer> map = new HashMap<>();
		int startRow = (Integer.parseInt(pageNum)-1) * 10;
		int endRow = Integer.parseInt(pageNum)*10;
		map.put("startRow", startRow);
		map.put("endRow", endRow);		
		return boardRepository.list(map);
	}

	@Override
	public List<BoardVo> view(int num) {
		return boardRepository.view(num);
	}

	@Override
	public void readCount(int num) {
		boardRepository.readCount(num);
	}

	@Override
	public int count() {
		return boardRepository.count();
	}

	@Override
	public void reply(String text, String num) {
		Map<String, Object> map = new HashMap<>();
		map.put("text", text);
		map.put("num", Integer.parseInt(num));
		boardRepository.reply(map);
	}

	@Override
	public List<BoardVo> replyList(String num) {
		return boardRepository.replyList(Integer.parseInt(num));
	}

	@Override
	public int replyCount(int num) {
		return boardRepository.replyCount(num);
	}
	
	
}
