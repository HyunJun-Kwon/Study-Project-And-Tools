package com.ipad.project.locationAnalysis.model;

import java.math.BigDecimal;

public class OpenCloseCountVO {
	private int year;
	private int openings;
	private int closures;
	private int count;
	
	public OpenCloseCountVO(BigDecimal year, BigDecimal openings, BigDecimal closures, BigDecimal count) {
		this.year = Integer.valueOf(String.valueOf(year));
		this.openings = Integer.valueOf(String.valueOf(openings));
		this.closures = Integer.valueOf(String.valueOf(closures));
		this.count = Integer.valueOf(String.valueOf(count));
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getOpenings() {
		return openings;
	}
	public void setOpenings(int openings) {
		this.openings = openings;
	}
	public int getClosures() {
		return closures;
	}
	public void setClosures(int closures) {
		this.closures = closures;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OpenCloseCountVO [year=" + year + ", openings=" + openings + ", closures=" + closures + ", count="
				+ count + "]";
	}
	
	
}
