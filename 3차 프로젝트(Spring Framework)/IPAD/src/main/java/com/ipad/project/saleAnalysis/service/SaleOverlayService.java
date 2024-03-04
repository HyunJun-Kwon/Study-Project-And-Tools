package com.ipad.project.saleAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.saleAnalysis.dao.ISaleRepository;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;

@Service
public class SaleOverlayService implements ISaleOverlayService{
	
	@Autowired
	ISaleRepository saleRepository;
	
	@Override
	public List<SaleOverlayVO> getOverlay() {
		return saleRepository.getOverlay();
	}
}
