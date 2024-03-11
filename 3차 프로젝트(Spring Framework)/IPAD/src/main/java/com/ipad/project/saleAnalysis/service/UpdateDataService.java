package com.ipad.project.saleAnalysis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipad.project.saleAnalysis.dao.IUpdateDataRepository;
import com.ipad.project.saleAnalysis.model.UpdateDataRepositoryParameter;
import com.ipad.project.saleAnalysis.model.UpdateRegionDataVO;

@Service
public class UpdateDataService implements IUpdateDataService {

	@Autowired
	IUpdateDataRepository updateDataRepository;
	@Autowired
	IGetOpenAPITokenService getOpenAPITokenService;

	String token;
	String url = "https://sgisapi.kostat.go.kr/OpenAPI3/stats/searchpopulation.json";

	int year = LocalDate.now().getYear();
	private ArrayList<Integer> ageTypeList = new ArrayList<>();
	private ArrayList<UpdateRegionDataVO> regionDataVO = new ArrayList<>();
	private ArrayList<Integer> houseHold = new ArrayList<>();
	private ArrayList<Integer> housePrice = new ArrayList<>();
	private ArrayList<Integer> dentalClinic = new ArrayList<>();
	private ArrayList<Integer> income = new ArrayList<>();
	private ArrayList<Integer> subway = new ArrayList<>();
	private ArrayList<Integer> bus = new ArrayList<>();
	private ArrayList<Integer> resident = new ArrayList<>();
	private ArrayList<Integer> floatPp = new ArrayList<>();
	ArrayList<String> code;
	
	public UpdateDataService(IGetOpenAPITokenService getOpenAPITokenService) {
		this.getOpenAPITokenService = getOpenAPITokenService;
		this.token = getOpenAPITokenService.getToken();
	}

	public void updateRegionDatas() {
		try {
			code = selectAdm();
			setHouseHold();
			setHousePrice();
			setDentalClinic();
			setIncome();
			setSubway();
			setBus();
			setResident();
			setFloatPp();
			for (int i = 0; i < code.size(); i++) {
				UpdateRegionDataVO vo = new UpdateRegionDataVO();
				vo.setAdm_cd(code.get(i));
				vo.setBus(bus.get(i));
				vo.setDentalClinic(dentalClinic.get(i));
				vo.setFloatingPp(floatPp.get(i));
				vo.setHouseHold(houseHold.get(i));
				vo.setHousePrice(housePrice.get(i));
				vo.setIncome(income.get(i));
				vo.setSubway(subway.get(i));
				vo.setResident(resident.get(i));
				regionDataVO.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// population API
	@Override
	public void InsertTotalData() {
		int checkNum = getRecordNum();
		updateRegionDatas();
		setAgeType();
		
		System.out.println(regionDataVO.get(0).getAdm_cd() + " " + regionDataVO.get(1).getDentalClinic());
		System.out.println("populationInsertData @@");
		JsonNode jsonData = null;
		Map<String,Object> map = null;
		System.out.println(checkNum + "@@@@@");
		System.out.println(regionDataVO.size() + "regionDataVO 사이즈");
		try {
			if (checkNum < regionDataVO.size()) {
				for (UpdateRegionDataVO vo : regionDataVO) {
					for (int age : ageTypeList) {
						try {
							jsonData = parseJsonData(fetchDataFromAPI(vo.getAdm_cd(), age));
							if (jsonData.get("errMsg").asText().equals("Success")) {
								JsonNode resultNode = jsonData.get("result");
								if (resultNode.isArray() && resultNode.size() > 0) {
									JsonNode populationNode = resultNode.get(0);
									map = convertJsonNodeToMap(populationNode);
									
									UpdateDataRepositoryParameter parameter = new UpdateDataRepositoryParameter(map, age, vo);
									insertData(parameter);
									System.out.println("insert실행 @@");
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} else if (checkNum == regionDataVO.size()) {
				System.out.println("else if 문 입장");
				for (UpdateRegionDataVO vo : regionDataVO) {
					for (int age : ageTypeList) {
						try {
							jsonData = parseJsonData(fetchDataFromAPI(vo.getAdm_cd(), age));
							if (jsonData.get("errMsg").asText().equals("Success")) {
								System.out.println(age + "41이 있나");
								JsonNode resultNode = jsonData.get("result");
								if (resultNode.isArray() && resultNode.size() > 0) {
									JsonNode populationNode = resultNode.get(0);
									map = convertJsonNodeToMap(populationNode);
									System.out.println(vo.getAdm_cd() + "vo adm_cd @@@@@@@@@@@@@");
									UpdateDataRepositoryParameter parameter = new UpdateDataRepositoryParameter(map, age, vo);
									updateData(parameter);
									System.out.println("update실행 @@");
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, Object> convertJsonNodeToMap(JsonNode jsonNode) {
        Map<String, Object> resultMap = new HashMap<>();

        // JsonNode의 필드를 반복하여 Map에 추가
        Iterator<String> fieldNames = jsonNode.fieldNames();
        System.out.println(fieldNames);
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode fieldNode = jsonNode.get(fieldName);
            
            resultMap.put(fieldName, fieldNode.asText());
        }
        return resultMap;
	}
	
	@Override
	public String fetchDataFromAPI(String code, int age) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(url);
		urlBuilder.append("?year=").append(year-2);
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
	public JsonNode parseJsonData(String jsonData) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readTree(jsonData);
	}

	// API 연령 타입
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
	public ArrayList<UpdateRegionDataVO> getRegionDataVO() {
		return regionDataVO;
	}

	@Override
	public void insertData(UpdateDataRepositoryParameter parameter) {
		updateDataRepository.insertRegionData(parameter);
	}

	@Override
	public void updateData(UpdateDataRepositoryParameter parameter) {
		updateDataRepository.updateRegionData(parameter);
	}

	@Override
	public int getRecordNum() {
		return updateDataRepository.getRecordNum();
	}

	@Override
	public ArrayList<String> selectAdm() {
		return updateDataRepository.selectAdm();
	}

	@Override
	public void setHouseHold() {
		houseHold.add(14453);
		houseHold.add(17258);
		houseHold.add(11322);
	}

	@Override
	public void setHousePrice() {
		housePrice.add(775064459);
		housePrice.add(1465657143);
		housePrice.add(1398833333);
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
	public void setFloatPp() {
		floatPp.add(3414090);
		floatPp.add(2240641);
		floatPp.add(664044);
	}

}
