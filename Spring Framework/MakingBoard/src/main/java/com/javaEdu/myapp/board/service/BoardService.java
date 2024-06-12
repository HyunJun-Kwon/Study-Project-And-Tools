package com.javaEdu.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaEdu.myapp.board.dao.IBoardRepository;
import com.javaEdu.myapp.board.model.BoardCheckVO;
import com.javaEdu.myapp.board.model.BoardVO;

@Service
public class BoardService implements IBoardService{
	
	@Autowired
	IBoardRepository boardRepo;
	
	@Override
	public List<BoardVO> list() {
		return boardRepo.list();
	}
	
	@Override
	public void write(BoardVO vo) {
		boardRepo.write(vo);
	}
	
	@Override
	public List<BoardVO> view(int num) {
		return boardRepo.view(num);
	}
	
	@Override
	public void readCount(int num) {
		boardRepo.readCount(num);
	}
	
	@Override
	public void delete(BoardCheckVO vo) {
		boardRepo.delete(vo);
	}
	
	@Override
	public List<BoardVO> loadEdit(BoardCheckVO vo) {
		return boardRepo.loadEdit(vo);
	}
	
	@Override
	public void edit(BoardVO vo) {
		boardRepo.edit(vo);
	}
	
	@Override
	public boolean checkPW(BoardCheckVO vo) {
		int result = boardRepo.checkPW(vo);
		
		if(result == 0) {
			return false;
		} else {
			return true;
		}
	}
}
