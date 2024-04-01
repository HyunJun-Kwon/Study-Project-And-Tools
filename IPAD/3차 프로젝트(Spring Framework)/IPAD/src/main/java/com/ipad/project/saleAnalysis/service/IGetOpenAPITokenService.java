package com.ipad.project.saleAnalysis.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public interface IGetOpenAPITokenService {
	public String getToken();
	public String fetchDataFromAPI() throws IOException;
	public JsonNode parseJsonData(String jsonData) throws IOException;
}
