package com.learning.batch;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Service
//@Component
public class AuthenticationService 
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BBGCache cache;
	
	private String apiKey ;

	public void generateApiKey() 
	{
		String BASE_URL =  cache.getPropertyMapValue("BASE_URL");
		
		HttpResponse<String> response = null;
		try 
		{
			Map<String, Object> authorizationMap = new HashMap<>();
			//authorizationMap.put("username", ramMarcCache.getPropertyMapValue("USER_NAME"));
			//authorizationMap.put("password", ramMarcCache.getPropertyMapValue("PASSWORD"));

	        String req = "[\r\n" + 
	        		"\r\n" + 
	        		"  { \"idType\": \"ID_ISIN\", \"idValue\": \"US4592001014\" }\r\n" + 
	        		"] ";
			
			response = Unirest.post(BASE_URL)
							  .header("Content-Type", "text/plain")
							  .body(req)
							  .asString();

			HttpResponse<JsonNode> jsonResponse  = Unirest.post(BASE_URL)
					  .header("Content-Type", "text/plain")
					  .body(req)
					  .asJson();			
			
		}catch (Exception e) 
		{
			log.error("Error while generating API Key", e);
		}
		log.info("Response -> " + response.getBody());
		apiKey =  response.getBody();
	}
	
	public void logout() 
	{
		
		String BASE_URL = cache.getPropertyMapValue("BASE_URL");
		
		HttpResponse<JsonNode> response = null;
		try {
			response = Unirest.post(BASE_URL + "/{namespace}/logout")
							  .header("accept", "application/json")
					          .routeParam("namespace", "apikey")
					          .queryString("apikey", apiKey).asJson();
		} catch (Exception e) {
			log.error("Error while Logout", e);
		}

		log.info("Response -> " + response.getBody());
	}
	
	public String getApiKey() {
		return apiKey;
	}
}
