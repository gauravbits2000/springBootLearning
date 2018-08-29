package com.learning.batch;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Service
public class BBGClientService<T> 
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BBGCache cache;
	
	@Autowired
	private AuthenticationService authenticationService;

	
/*	public List<T> getBBGData( List<Job> jobs) throws Exception
	{
		List<Job> outputList = new ArrayList<Job>();
		
		for(Job job: outputList)
		{
			
			getBBGData(job.));
		}
		
		return outputList;
	}*/
	
	public List<T> getBBGData(String idType, String idValue) throws Exception
	{
		
		log.info("******* GET Request to Fetch Complete Ratings for : " + idType + " *******");
		
		String BASE_URL = cache.getPropertyMapValue("BASE_URL");
		
		HttpResponse<JsonNode> response = null;
		List<T> ratingList = new ArrayList<T>();
		
		response = Unirest.post(BASE_URL + "/{namespace}/{entity}/latest")
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
		}
		
		log.info("******* GET Request Finished for : " + idType + " *******");
		return ratingList;
	}
	
	private List<T> parseJsonToJava(JSONArray jsonArray, Class<T> className) throws Exception{
		List<T> list = new ArrayList<T>();
		for(int i = 0 ; i < jsonArray.length() ; i++) {
			/*T parsedObject = objectMapper.readValue(jsonArray.get(i).toString().getBytes(), className);
			list.add(parsedObject);*/
		}
		return list;
	}

}
