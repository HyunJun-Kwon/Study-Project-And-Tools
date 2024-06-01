package com.myhome.myapp.homeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.myapp.homeBoard.dao.IHomeBoardRepository;
import com.myhome.myapp.homeBoard.model.HomeBoardVO;

@Service
public class HomeBoardService implements IHomeBoardService{
	
	@Autowired
	IHomeBoardRepository HomeBoardRepository;
	
	public List<HomeBoardVO> list() {
		return HomeBoardRepository.list();
	}
}
