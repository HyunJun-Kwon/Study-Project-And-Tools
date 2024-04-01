package com.ipad.project.locationAnalysis.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipad.project.locationAnalysis.model.PopulationForecastVO;
@Repository
public interface IPopulationForecastRepository {
	ArrayList<PopulationForecastVO> getPopulation();
    void saveData(PopulationForecastVO vo);
    int getNumberHouse(String region);
    int getFamily(String region);
}
