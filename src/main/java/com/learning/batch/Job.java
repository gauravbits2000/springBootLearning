package com.learning.batch;

public class Job
{
	private String idType, idValue, exchCode, micCode, currency, marketSecDes;

	public Job(String idType, String idValue) 
	{
	    this.idType = idType;
	    this.idValue = idValue;
	    this.exchCode = null;
	    this.micCode = null;
	    this.currency = null;
	    this.marketSecDes = null;
	}
	
	public Job exchCode(String exchCode) 
	{
	    this.exchCode = exchCode;
	    return this;
	}
	
	public Job micCode(String micCode) 
	{
	    this.micCode = micCode;
	    return this;
	}
	
	public Job currency(String currency) 
	{
	    this.currency = currency;
	    return this;
	}
	
	public Job marketSecDes(String marketSecDes) 
	{
	    this.marketSecDes = marketSecDes;
	    return this;
	}

	public String toJsonObject() 
	{
	    StringBuilder jsonSb = new StringBuilder("{");
	
	    jsonSb.append(jsonKeyValuePair("idType", this.idType))
	        .append(",")
	        .append(jsonKeyValuePair("idValue", this.idValue));
	
	    if (this.exchCode != null) {
	        jsonSb.append(",").append(jsonKeyValuePair("exchCode", this.exchCode));
	    }
	
	    if (this.micCode != null) {
	        jsonSb.append(",").append(jsonKeyValuePair("micCode", this.micCode));
	    }
	
	    if (this.currency != null) {
	        jsonSb.append(",").append(jsonKeyValuePair("currency", this.currency));
	    }
	
	    if (this.marketSecDes != null) {
	        jsonSb.append(",").append(jsonKeyValuePair("marketSecDes", this.marketSecDes));
	    }
	
	    return jsonSb.append("}").toString();
	}

	private String jsonKeyValuePair(String key, String value) {
	    return "\"" + key + "\":\"" + value + "\"";
	}

}
