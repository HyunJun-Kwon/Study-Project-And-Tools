package com.ipad.project.population.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ipad.project.getRegionData.service.IGetRegionDataService;
import com.ipad.project.population.dao.IRegionDataUpdateRepository;
import com.ipad.project.population.model.RegionDataUpdateVO;

@Service
public class RegionDataUpdateService implements IRegionDataUpdateService {

	@Autowired
	IRegionDataUpdateRepository regionDataUpdateRepository;

	@Autowired
	IGetRegionDataService getRegionDataService;
	ArrayList<Integer> household = new ArrayList<>();
	ArrayList<Integer> houseprice = new ArrayList<>();
	ArrayList<Integer> dentalClinic = new ArrayList<>();
	ArrayList<Integer> income = new ArrayList<>();
	ArrayList<Integer> subway = new ArrayList<>();
	ArrayList<Integer> bus = new ArrayList<>();
	ArrayList<Integer> resident = new ArrayList<>();
	ArrayList<Integer> floatpp = new ArrayList<>();
	ArrayList<String> code = new ArrayList<>();
	ArrayList<Integer> ageTypeList = new ArrayList<>();
	ArrayList<RegionDataUpdateVO> vos = new ArrayList<>();

	private String token;
	private String url = "https://sgisapi.kostat.go.kr/OpenAPI3/stats/searchpopulation.json";
	private String urlToken = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json?consumer_key=8af4905dff204c43abf0&consumer_secret=49f8b27eca57460d997d";
	private int year = LocalDate.now().getYear();

	@Override
	public void setVO() {
		token = getToken();
		code = selectAdm();
		setBus();
		setDentalClinic();
		setFloatpp();
		setHousehold();
		setHouseprice();
		setIncome();
		setResident();
		setSubway();
		setAgeType();
		for (int i = 0; i < code.size(); i++) {
			RegionDataUpdateVO vo = new RegionDataUpdateVO();
			vo.setAdm_cd(code.get(i));
			vo.setBus(bus.get(i));
			vo.setDentalClinic(dentalClinic.get(i));
			vo.setFloatingPp(floatpp.get(i));
			vo.setHouseHold(household.get(i));
			vo.setHousePrice(houseprice.get(i));
			vo.setIncome(income.get(i));
			vo.setSubway(subway.get(i));
			vo.setResident(resident.get(i));
			vos.add(vo);
		}
	}
	@Override
	public ArrayList<String> selectAdm() {
		return regionDataUpdateRepository.selectAdm();
	}
	@Override
	public void insertRegion() {
		for (String code : code) {
			regionDataUpdateRepository.insertRegion(code);
			regionDataUpdateRepository.insertRegionSale(code);
		}
	}
	@Override
	public void insertOtherData(RegionDataUpdateVO vo) {
		regionDataUpdateRepository.insertOtherData(vo);
	}
	@Override
	public void updatePopulation(ObjectNode obj) {
		Map<String, Object> map = new HashMap<>();
		map.put("population", obj.get("population").asInt());
		map.put("age", obj.get("age").asInt());
		map.put("adm_cd", obj.get("adm_cd").asText());
		regionDataUpdateRepository.updatePopulation(map);
	}
	@Override
	public String fetchDataFromAPI(String code, int age) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(url);
		urlBuilder.append("?year=").append(year - 2);
		urlBuilder.append("&adm_cd=").append(code);
		urlBuilder.append("&accessToken=").append(token);
		if (age != 41) {
			urlBuilder.append("&age_type=").append(age);
		}
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new URL(urlBuilder.toString()).openStream()))) {
			StringBuilder apiResponse = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				apiResponse.append(line);
			}
			return apiResponse.toString();
		}
	}
	@Override
	public ArrayList<String> regionCheck() {
		return regionDataUpdateRepository.regionCheck();
	}
	@Override
	public void insertData() {
		JsonNode jsonData = null;
		if (regionCheck().size() != 0) {
			setVO();
		}
		code = regionCheck();
		insertRegion();
		if (code.size() == 0) {
			for (String code : code) {
				for (RegionDataUpdateVO vo : vos) {
					vo.setAdm_cd(code);
					insertOtherData(vo);
					for (int age : ageTypeList) {
						try {
							jsonData = parseJsonData(fetchDataFromAPI(code, age));
							if (jsonData.get("errMsg").asText().equals("Success")) {
								JsonNode resultNode = jsonData.get("result");
								if (resultNode.isArray() && resultNode.size() > 0) {
									JsonNode populationNode = resultNode.get(0);
									ObjectNode obj = (ObjectNode) populationNode;
									obj.put("age", age);
									updatePopulation(obj);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					updateSale(code);
				}
			}
		} else {
			for (RegionDataUpdateVO vo : vos) {
				insertOtherData(vo);
			}
			for (String code : code) {
				for (int age : ageTypeList) {
					try {
						jsonData = parseJsonData(fetchDataFromAPI(code, age));
						if (jsonData.get("errMsg").asText().equals("Success")) {
							JsonNode resultNode = jsonData.get("result");
							if (resultNode.isArray() && resultNode.size() > 0) {
								JsonNode populationNode = resultNode.get(0);
								ObjectNode obj = (ObjectNode) populationNode;
								obj.put("age", age);
								updatePopulation(obj);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				updateSale(code);
			}
		}
	}

	@Override
	public void addRegion() {
		for (String code : code) {
			regionDataUpdateRepository.addRegion(code);
		}
	}
	@Override
	public void updateSale(String adm_cd) {
		Map<String, Object> map = new HashMap<>();
		map.put("adm_cd", adm_cd);
		map.put("sale", getRegionDataService.calculateSale(adm_cd));
		regionDataUpdateRepository.updateSale(map);
	}
	@Override
	public void setHousehold() {
		household.add(14453);
		household.add(17258);
		household.add(11322);
	}
	@Override
	public void setHouseprice() {
		houseprice.add(775064459);
		houseprice.add(1465657143);
		houseprice.add(1398833333);
	}
	@Override
	public void setDentalClinic() {
		dentalClinic.add(6);
		dentalClinic.add(29);
		dentalClinic.add(5);
	}
	@Override
	public void setIncome() {
		income.add(3920833);
		income.add(3802500);
		income.add(4405000);
	}
	@Override
	public void setSubway() {
		subway.add(0);
		subway.add(1);
		subway.add(0);
	}
	@Override
	public void setBus() {
		bus.add(32);
		bus.add(49);
		bus.add(13);
	}
	@Override
	public void setResident() {
		resident.add(44466);
		resident.add(32487);
		resident.add(43003);

	}
	@Override
	public void setFloatpp() {
		floatpp.add(3414090);
		floatpp.add(2240641);
		floatpp.add(664044);
	}
	@Override
	public void setAgeType() {
		ageTypeList.add(41);
		for (int i = 30; i <= 40; i++) {
			if (i != 37 && i != 38 && i != 39) {
				ageTypeList.add(i);
			}
		}
	}
	@Override
	public String getToken() {
		try {
			String apiResponse = fetchDataFromAPI();
			JsonNode jsonData = parseJsonData(apiResponse);
			JsonNode tokenNode = jsonData.get("result");
			token = tokenNode.get("accessToken").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}
	@Override
	public String fetchDataFromAPI() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(urlToken);
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new URL(urlBuilder.toString()).openStream()))) {
			StringBuilder apiResponse = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				apiResponse.append(line);
			}
			return apiResponse.toString();
		}
	}
	@Override
	public JsonNode parseJsonData(String jsonData) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readTree(jsonData);
	}
}
