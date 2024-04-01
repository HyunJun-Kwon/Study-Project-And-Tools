package com.ipad.project.saleAnalysis.dao;

import java.util.ArrayList;
import java.util.List;

import com.ipad.project.saleAnalysis.model.UpdateDataRepositoryParameter;

public interface IUpdateDataRepository {
	int getRecordNum();
	ArrayList<String> selectAdm();
	void insertRegionData(UpdateDataRepositoryParameter parameter);
	void updateRegionData(UpdateDataRepositoryParameter parameter);
}
