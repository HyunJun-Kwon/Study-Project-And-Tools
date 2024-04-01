package com.ipad.project.locationAnalysis.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipad.project.locationAnalysis.model.OpenCloseCountVO;
@Repository
public interface IOpenCloseCountRepository {

	ArrayList<OpenCloseCountVO> getOpenData();
    void saveOpenData(int year, int count);
    void updateOpenData(int year, int count);
    void saveCloseData(int year, int count);
    void saveHospitalCountData(int year, int count);
    int getOpenData(int year);
    int getCloseData(int year);
    int getHospitalCount(int year);
}
