package com.ipad.project.locationRecommand.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ipad.project.locationRecommand.model.RecommandVO;

@Repository
public interface IRecommandRepository {

	int avgData(String data);

	int minData(String option);

	int maxData(String option);

	List<Map<String, Object>> selectRegion();
}
