package com.ipad.project.saleAnalysis.model;

public class RegionDataVO {
	private String adm_cd;
	private int population;
	private int floatPp;
	private int income;
	private int dentalclinic;
	private int twenties;
	private int thirties;
	private int sixties;
	private int over70s;
	private int subway;
	
	public RegionDataVO() {}
	
	public RegionDataVO(int population, int floatPp, int income, int dentalclinic) {
		this.population = population;
		this.floatPp = floatPp;
		this.income = income;
		this.dentalclinic = dentalclinic;
	}
	
	public RegionDataVO(String adm_cd, int twenties, int thirties, int sixties, int over70s, int floatPp, int income, int dentalclinic, int subway) {
		this.adm_cd = adm_cd;
		this.twenties = twenties;
		this.thirties = thirties;
		this.sixties = sixties;
		this.over70s = over70s;
		this.floatPp = floatPp;
		this.income = income;
		this.dentalclinic = dentalclinic;
		this.subway = subway;
	}
	
	public String getAdm_cd() {
		return adm_cd;
	}

	public void setAdm_cd(String adm_cd) {
		this.adm_cd = adm_cd;
	}

	public int getTwenties() {
		return twenties;
	}

	public void setTwenties(int twenties) {
		this.twenties = twenties;
	}

	public int getThirties() {
		return thirties;
	}

	public void setThirties(int thirties) {
		this.thirties = thirties;
	}

	public int getSixties() {
		return sixties;
	}

	public void setSixties(int sixties) {
		this.sixties = sixties;
	}

	public int getOver70s() {
		return over70s;
	}

	public void setOver70s(int over70s) {
		this.over70s = over70s;
	}

	public int getSubway() {
		return subway;
	}

	public void setSubway(int subway) {
		this.subway = subway;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getFloatPp() {
		return floatPp;
	}

	public void setFloatPp(int floatPp) {
		this.floatPp = floatPp;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getDentalclinic() {
		return dentalclinic;
	}

	public void setDentalclinic(int dentalclinic) {
		this.dentalclinic = dentalclinic;
	}
	
	
}
