package com.learning.batch;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BBGCache 
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private Map<String, String> propertyMap = new HashMap<String, String>();
	
	
	public void initializeCache()
	{
		initializePropertyMap();
	}

	private void initializePropertyMap() 
	{	
		log.info("=====> Initializing BBG-OS Cache...........");	
		propertyMap.clear();
		
		
		propertyMap.put("BASE_URL", "https://api.openfigi.com/v1/mapping");
	    log.info("=====> Initialize Cache finished....");
		
	}

	public String getPropertyMapValue(String key) 
	{	
		if(propertyMap.isEmpty()) 
		{
			initializePropertyMap();
		}
        return propertyMap.get(key);
    }

}
