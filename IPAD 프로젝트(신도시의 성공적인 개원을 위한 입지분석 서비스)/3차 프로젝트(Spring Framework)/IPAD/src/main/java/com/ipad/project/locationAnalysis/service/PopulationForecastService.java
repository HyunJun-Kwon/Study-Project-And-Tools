package com.ipad.project.locationAnalysis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.locationAnalysis.dao.IPopulationForecastRepository;
import com.ipad.project.locationAnalysis.model.PopulationForecastVO;
@Service
public class PopulationForecastService implements IPopulationForecastService {

	@Autowired
	IPopulationForecastRepository pfr;
	@Override
	public ArrayList<PopulationForecastVO> getPopulation() {
		// TODO Auto-generated method stub
		return pfr.getPopulation();
	}

	@Override
	public void saveData(PopulationForecastVO vo) {
		// TODO Auto-generated method stub
		pfr.saveData(vo);
	}

	@Override
	public int getNumberHouse(String region) {
		// TODO Auto-generated method stub
		return pfr.getNumberHouse(region);
	}

	@Override
	public int getFamily(String region) {
		// TODO Auto-generated method stub
		return pfr.getFamily(region);
	}

}
