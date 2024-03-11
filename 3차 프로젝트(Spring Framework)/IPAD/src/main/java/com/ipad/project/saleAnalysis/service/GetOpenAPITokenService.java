package com.ipad.project.saleAnalysis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GetOpenAPITokenService implements IGetOpenAPITokenService {
	private String url = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json?consumer_key=8af4905dff204c43abf0&consumer_secret=49f8b27eca57460d997d";
	private String token;

	// JsonNode에서 토큰을 가져오는 메소드
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

	// url로 요청해서 json으로 데이터 가져오는 메소드
	public String fetchDataFromAPI() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(url);
		
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(new URL(urlBuilder.toString()).openStream()))) {
			StringBuilder apiResponse = new StringBuilder();
			String line;
			while((line=reader.readLine()) != null) {
				apiResponse.append(line);
			}
			return apiResponse.toString();
		}
	}
	
	// json 형식으로 string을 JsonNode로 변경하는 메소드
	public JsonNode parseJsonData(String jsonData) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readTree(jsonData);
	}
}
