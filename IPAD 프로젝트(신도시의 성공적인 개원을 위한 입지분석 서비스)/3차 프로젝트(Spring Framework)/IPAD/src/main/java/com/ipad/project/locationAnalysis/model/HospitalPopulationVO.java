package com.ipad.project.locationAnalysis.model;

public class HospitalPopulationVO {
	private String region;
	private String population;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "HospitalPopulationVO [region=" + region + ", population=" + population + "]";
	}
	
	
}
