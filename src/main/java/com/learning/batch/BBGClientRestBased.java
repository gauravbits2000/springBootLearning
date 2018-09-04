package com.learning.batch;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BBGClientRestBased<T> 
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BBGCache cache;
	
	@Autowired
	private AuthenticationService authenticationService;

	
	public List<T> getBBGData(String idType, String idValue) throws Exception
	{
		
		log.info("******* GET Request to Fetch Complete Ratings for : " + idType + " *******");
		
		String BASE_URL = cache.getPropertyMapValue("BASE_URL");

		
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("idType", idType);
        headers.set("idValue", idValue);
		
        
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, //
                											    HttpMethod.POST, 
                											    entity, 
                											    String.class);
 
        String result = response.getBody();
 
        System.out.println(result);
		
/*		HttpResponse<JsonNode> response = null;
		List<T> ratingList = new ArrayList<T>();
		
		response = Unirest.post(BASE_URL)
						  .header("accept", "application/json")
						  .field("idType", idType)
						  .field("idValue", idValue)
						  //.routeParam("namespace", "ramr")
						  //.routeParam("entity", entity)
						  //.queryString("apikey", authenticationService.getApiKey())
						  .asJson();
		
		if (response.getStatus() == 200) {
			JSONArray jsonArray = response.getBody().getArray();
			log.info("Raw Size -> " + jsonArray.length());
			//ratingList = parseJsonToJava(jsonArray, className);
			log.info("Parsed Rating Size -> " + ratingList.size());
		}*/
		
		log.info("******* GET Request Finished for : " + idType + " *******");
		return null;
	}
	
	private List<T> parseJsonToJava(JSONArray jsonArray, Class<T> className) throws Exception{
		List<T> list = new ArrayList<T>();
		for(int i = 0 ; i < jsonArray.length() ; i++) {
			/*T parsedObject = objectMapper.readValue(jsonArray.get(i).toString().getBytes(), className);
			list.add(parsedObject);*/
		}
		return list;
	}
	
	public static void main(String args)
	{
		System.out.println("started");
	}

}
