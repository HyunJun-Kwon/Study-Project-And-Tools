package com.ipad.project.locationAnalysis.service;

import java.util.ArrayList;

import com.ipad.project.locationAnalysis.model.PopulationForecastVO;

public interface IPopulationForecastService {
	ArrayList<PopulationForecastVO> getPopulation();
    void saveData(PopulationForecastVO vo);
    int getNumberHouse(String region);
    int getFamily(String region);
}
