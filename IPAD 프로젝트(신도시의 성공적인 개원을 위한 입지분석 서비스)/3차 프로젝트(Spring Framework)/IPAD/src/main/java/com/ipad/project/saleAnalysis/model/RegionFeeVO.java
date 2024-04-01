package com.ipad.project.saleAnalysis.model;

public class RegionFeeVO {
	private String adm_cd;
	private int rent_per;
	private int under_three_year;
	private int over_ten_year;
	private int average;
	
	public int getUnder_three_year() {
		return under_three_year;
	}
	public void setUnder_three_year(int under_three_year) {
		this.under_three_year = under_three_year;
	}
	public int getOver_ten_year() {
		return over_ten_year;
	}
	public void setOver_ten_year(int over_ten_year) {
		this.over_ten_year = over_ten_year;
	}
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public String getAdm_cd() {
		return adm_cd;
	}
	public void setAdm_cd(String adm_cd) {
		this.adm_cd = adm_cd;
	}
	public int getRent_per() {
		return rent_per;
	}
	public void setRent_per(int rent_per) {
		this.rent_per = rent_per;
	}
}
