package com.javaEdu.myapp.board.service;

import java.util.List;

import com.javaEdu.myapp.board.model.BoardCheckVO;
import com.javaEdu.myapp.board.model.BoardVO;

public interface IBoardService {
	public List<BoardVO> list();
	public void write(BoardVO vo);
	public List<BoardVO> view(int num);
	public void readCount(int num);
	public void delete(BoardCheckVO vo);
	public List<BoardVO> loadEdit(BoardCheckVO vo);
	public void edit(BoardVO vo);
	public boolean checkPW(BoardCheckVO vo);
}
