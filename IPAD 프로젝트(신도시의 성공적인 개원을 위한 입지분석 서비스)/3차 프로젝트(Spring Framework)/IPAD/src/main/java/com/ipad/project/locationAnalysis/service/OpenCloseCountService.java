package com.ipad.project.locationAnalysis.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.locationAnalysis.dao.IOpenCloseCountRepository;
import com.ipad.project.locationAnalysis.model.OpenCloseCountVO;
@Service
public class OpenCloseCountService implements IOpenCloseCountService {
	@Autowired
	IOpenCloseCountRepository occr;
	@Override
	public ArrayList<OpenCloseCountVO> getOpenData() {
		// TODO Auto-generated method stub
		return occr.getOpenData();
	}

	@Override
	public void saveOpenData(int year, int count) {
		// TODO Auto-generated method stub
		occr.saveOpenData(year, count);
	}

	@Override
	public void updateOpenData(int year, int count) {
		// TODO Auto-generated method stub
		occr.updateOpenData(year, count);
	}

	@Override
	public void saveCloseData(int year, int count) {
		// TODO Auto-generated method stub
		occr.saveCloseData(year, count);
	}

	@Override
	public void saveHospitalCountData(int year, int count) {
		// TODO Auto-generated method stub
		occr.saveHospitalCountData(year, count);
	}

	@Override
	public int getOpenData(int year) {
		// TODO Auto-generated method stub
		return occr.getOpenData(year);
	}

	@Override
	public int getCloseData(int year) {
		// TODO Auto-generated method stub
		return occr.getCloseData(year);
	}

	@Override
	public int getHospitalCount(int year) {
		// TODO Auto-generated method stub
		return occr.getHospitalCount(year);
	}

	@Override
	public void saveData() {
		for (int i = 2015; i <= LocalDate.now().getYear(); i++) {
			occr.saveOpenData(i, occr.getOpenData(i));
			occr.saveCloseData(i, occr.getCloseData(i));
			occr.saveHospitalCountData(i, occr.getHospitalCount(i));
			occr.updateOpenData(i, occr.getOpenData(i));
		}

	}

}
