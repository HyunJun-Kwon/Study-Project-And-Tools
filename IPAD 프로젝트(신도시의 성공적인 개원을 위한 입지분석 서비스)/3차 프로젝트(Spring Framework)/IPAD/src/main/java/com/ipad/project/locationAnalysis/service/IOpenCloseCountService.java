package com.ipad.project.locationAnalysis.service;

import java.util.ArrayList;

import com.ipad.project.locationAnalysis.model.OpenCloseCountVO;

public interface IOpenCloseCountService {
	ArrayList<OpenCloseCountVO> getOpenData();
    void saveOpenData(int year, int count);
    void updateOpenData(int year, int count);
    void saveCloseData(int year, int count);
    void saveHospitalCountData(int year, int count);
    int getOpenData(int year);
    int getCloseData(int year);
    int getHospitalCount(int year);
    void saveData();
}
