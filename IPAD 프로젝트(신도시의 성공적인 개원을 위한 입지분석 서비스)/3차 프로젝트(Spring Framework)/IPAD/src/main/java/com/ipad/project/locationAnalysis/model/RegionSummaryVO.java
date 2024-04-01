package com.ipad.project.locationAnalysis.model;

public class RegionSummaryVO {
	private String region;
	private String hospitalCount;
	private String footTraffic;
	private String residetnPopulation;
	private String hospitalPopulation;
	private String maxAgeGroup;

	public RegionSummaryVO() {
		region = "";
		hospitalCount = "";
		footTraffic = "";
		residetnPopulation = "";
		hospitalPopulation = "";
		maxAgeGroup = "";
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getHospitalCount() {
		return hospitalCount;
	}

	public void setHospitalCount(String hospitalCount) {
		this.hospitalCount = hospitalCount;
	}

	public String getFootTraffic() {
		return footTraffic;
	}

	public void setFootTraffic(String footTraffic) {
		this.footTraffic = footTraffic;
	}

	public String getResidetnPopulation() {
		return residetnPopulation;
	}

	public void setResidetnPopulation(String residetnPopulation) {
		this.residetnPopulation = residetnPopulation;
	}

	public String getHospitalPopulation() {
		return hospitalPopulation;
	}

	public void setHospitalPopulation(String hospitalPopulation) {
		this.hospitalPopulation = hospitalPopulation;
	}

	public String getMaxAgeGroup() {
		return maxAgeGroup;
	}

	public void setMaxAgeGroup(String maxAgeGroup) {
		this.maxAgeGroup = maxAgeGroup;
	}

	@Override
	public String toString() {
		return "RegionSummaryVO [region=" + region + ", hospitalCount=" + hospitalCount + ", footTraffic=" + footTraffic
				+ ", residetnPopulation=" + residetnPopulation + ", hospitalPopulation=" + hospitalPopulation
				+ ", maxAgeGroup=" + maxAgeGroup + "]";
	}
	
}
