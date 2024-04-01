package com.ipad.project.locationAnalysis.model;

import java.math.BigDecimal;

public class HospitalCountVO {
	private String year;
	private String region;
	private String count;
	
	public HospitalCountVO(String year, String region, String count) {
		this.year = year;
		this.region = region;
		this.count = count;
	}
	
	public HospitalCountVO(String region, BigDecimal count) {
	      this.region=region;
	      this.count= String.valueOf(count);
	   }
	public HospitalCountVO(String region, BigDecimal count, BigDecimal year) {
		this.region=region;
		this.count=String.valueOf(count);
		this.year=String.valueOf(year);
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "HospitalCountVO [year=" + year + ", region=" + region + ", count=" + count + "]";
	}

	
}
