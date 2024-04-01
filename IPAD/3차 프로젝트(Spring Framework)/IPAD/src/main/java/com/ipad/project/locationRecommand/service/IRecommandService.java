package com.ipad.project.locationRecommand.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ipad.project.locationRecommand.model.RecommandVO;

public interface IRecommandService {
	List<RecommandVO> recommandRegion(boolean opt1, boolean opt2);
	
	int avgData(String data);
	void setSaleScore(RecommandVO dto);
	void setTeensScore(RecommandVO dto);
	void setTwentiesScore(RecommandVO dto);
	void setSixtiesScore(RecommandVO dto);
	void setOver70sScore(RecommandVO dto);
	void setTotalScore(RecommandVO dto, boolean opt1, boolean opt2);
	void setScore(ArrayList<RecommandVO> dtos, boolean opt1, boolean opt2);
	int minData(String option);
	int maxData(String option);
	List<Map<String, Object>> selectRegion();
	double getMaxScore(ArrayList<RecommandVO> dtos);
	List<RecommandVO> getTop3List(List<RecommandVO> dtos);
	
}
