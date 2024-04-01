package com.ipad.project.board.service;

import java.util.List;

import com.ipad.project.board.model.BoardVo;

public interface IBoardService {
	public void write(BoardVo vo);
	public void delete(String num);
	public void edit(BoardVo vo);
	public void readCount(int num);
	public List<BoardVo> list(String pageNum);
	public List<BoardVo> view(int num);
	public int count();
	public void reply(String text, String num);
	public List<BoardVo> replyList(String num);
	public int replyCount(int num);
}
