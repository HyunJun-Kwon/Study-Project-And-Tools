package com.ipad.project.getRegionData.model;

public class GetRegionDataVO {
	private String adm_cd;
	private String region_name;
	private int predictSale;
	private int predictPatient;
	private int size;
	private int employee;
	private int netProfit;

	private int rentFee;
	private int employment_cost;

	public int getRentFee() {
		return rentFee;
	}

	public void setRentFee(int rentFee) {
		this.rentFee = rentFee;
	}

	public int getEmployment_cost() {
		return employment_cost;
	}

	public void setEmployment_cost(int employment_cost) {
		this.employment_cost = employment_cost;
	}

	public GetRegionDataVO() {

	}

	public GetRegionDataVO(int predictPatient, int employee, int size, int predictSale, int netProfit) {
		this.predictPatient = predictPatient;
		this.employee = employee;
		this.size = size;
		this.predictSale = predictSale;
		this.netProfit = netProfit;
	}

	public int getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(int netProfit) {
		this.netProfit = netProfit;
	}

	public String getAdm_cd() {
		return adm_cd;
	}

	public void setAdm_cd(String adm_cd) {
		this.adm_cd = adm_cd;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public int getPredictSale() {
		return predictSale;
	}

	public void setPredictSale(int predictSale) {
		this.predictSale = predictSale;
	}

	public int getPredictPatient() {
		return predictPatient;
	}

	public void setPredictPatient(int predictPatient) {
		this.predictPatient = predictPatient;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

}
