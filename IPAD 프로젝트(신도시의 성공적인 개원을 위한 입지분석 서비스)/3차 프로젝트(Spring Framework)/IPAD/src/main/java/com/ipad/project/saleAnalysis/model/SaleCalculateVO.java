package com.ipad.project.saleAnalysis.model;

public class SaleCalculateVO {
	private String adm_cd;
	private String region_name;
	private int predictSale;
	private int predictPatient;
	private int rent_size;
	private int employee_count;
	private int netProfit;
	private int rentFee;
	private int employment_cost;
	private int deptAmount;
	
	public SaleCalculateVO(int rent_size, int employee_count) {
		this.rent_size = rent_size;
		this.employee_count = employee_count;
	}
	
	public SaleCalculateVO(int predictSale, int predictPatient, int rentFee, int employment_cost, int deptAmount, int netProfit) {
		this.predictSale = predictSale;
		this.predictPatient = predictPatient;
		this.rentFee = rentFee;
		this.employment_cost = employment_cost;
		this.deptAmount = deptAmount;
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

	public int getRent_size() {
		return rent_size;
	}

	public void setRent_size(int rent_size) {
		this.rent_size = rent_size;
	}

	public int getEmployee_count() {
		return employee_count;
	}

	public void setEmployee_count(int employee_count) {
		this.employee_count = employee_count;
	}

	public int getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(int netProfit) {
		this.netProfit = netProfit;
	}

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

	public int getDeptAmount() {
		return deptAmount;
	}

	public void setDeptAmount(int deptAmount) {
		this.deptAmount = deptAmount;
	}
}
