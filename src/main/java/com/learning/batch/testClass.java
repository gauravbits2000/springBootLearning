package com.learning.batch;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class testClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String BASE_URL = "https://api.openfigi.com/v1/mapping";

		
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.set("idType", "ID_SEDOL");
        //headers.set("idValue", "1234567");
		
        
        String req = "[\r\n" + 
        		"\r\n" + 
        		"  { \"idType\": \"ID_ISIN\", \"idValue\": \"US4592001014\" }\r\n" + 
        		"] ";

        HttpEntity<?> entity = new HttpEntity<Object>(req, headers);
        
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, //
                											    HttpMethod.POST, 
                											    entity, 
                											    String.class);
        
      
        
 
        String result = response.getBody();
 
        System.out.println(result);

	}

}
