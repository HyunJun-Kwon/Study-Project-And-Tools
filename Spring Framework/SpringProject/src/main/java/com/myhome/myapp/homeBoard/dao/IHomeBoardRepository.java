package com.myhome.myapp.homeBoard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myhome.myapp.homeBoard.model.HomeBoardVO;

@Repository
public interface IHomeBoardRepository {
	public List<HomeBoardVO> list();
}
