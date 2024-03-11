package com.ipad.project.saleAnalysis.model;

import java.util.Map;

public class UpdateDataRepositoryParameter {
	private Map<String,Object> record;
	private int age;
	private UpdateRegionDataVO vo;
	
	public UpdateDataRepositoryParameter(Map<String,Object> record, int age, UpdateRegionDataVO vo) {
		this.record = record;
		this.age = age;
		this.vo = vo;
	}
	
	public Map<String, Object> getRecord() {
		return record;
	}
	public void setRecord(Map<String, Object> record) {
		this.record = record;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UpdateRegionDataVO getVo() {
		return vo;
	}
	public void setVo(UpdateRegionDataVO vo) {
		this.vo = vo;
	}
}
