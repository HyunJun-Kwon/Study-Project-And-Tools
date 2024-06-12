package com.javaEdu.myapp.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaEdu.myapp.board.model.BoardCheckVO;
import com.javaEdu.myapp.board.model.BoardVO;

@Repository
public interface IBoardRepository {
	public List<BoardVO> list();
	public void write(BoardVO vo);
	public void readCount(int num);
	public List<BoardVO> view(int num);
	public void delete(BoardCheckVO vo);
	public List<BoardVO> loadEdit(BoardCheckVO vo);
	public void edit(BoardVO vo);
	public int checkPW(BoardCheckVO vo);
}
