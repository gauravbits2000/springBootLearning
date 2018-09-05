package com.learning.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BBGServiceStarter implements CommandLineRunner
{
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private BBGClientService client;
	
	@Autowired
	private BBGClientRestBased clientRestBased;
	
	public static void main(String[] args) 
	{
		System.out.println("Starting");
		SpringApplication.run(starting.class, args);

	}
	
	 private Job createJob(String idType, String idValue) 
	 {
	        return new Job(idType, idValue);
	    }
	
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Inside Run");
		
		BBGServiceStarter app = new BBGServiceStarter();
		

		clientRestBased.getBBGData("ID_CUSIP", "123456789");


	}
	
	
   private static String join(String sep, List<String> list)
   {
        if (list.size() == 0) 
        {
            return "";
        }

        StringBuilder sb = new StringBuilder(list.get(0));

        for(int i = 1, len = list.size(); i < len; i++) 
        {
            sb.append(sep).append(list.get(i));
        }

        return sb.toString();
    }	
	   /* Figi class */

    static class Figi {
        public String figi, securityType, marketSector, ticker, name, uniqueID,
            exchCode, shareClassFIGI, compositeFIGI, securityType2,
            securityDescription, uniqueIDFutOpt;

        public String toString() {
            return (new StringBuilder())
                .append("figi: ").append(this.figi).append("\n")
                .append("securityType: ").append(this.securityType).append("\n")
                .append("marketSector: ").append(this.marketSector).append("\n")
                .append("ticker: ").append(this.ticker).append("\n")
                .append("name: ").append(this.name).append("\n")
                .append("uniqueID: ").append(this.uniqueID).append("\n")
                .append("exchCode: ").append(this.exchCode).append("\n")
                .append("shareClassFIGI: ").append(this.shareClassFIGI).append("\n")
                .append("compositeFIGI: ").append(this.compositeFIGI).append("\n")
                .append("securityType2: ").append(this.securityType2).append("\n")
                .append("securityDescription: ").append(this.securityDescription).append("\n")
                .append("uniqueIDFutOpt: ").append(this.uniqueIDFutOpt)
                .append("\n")
                .toString();
        }
    }
	
	static class JobResult
	{
        public String 		error;
        public List<Figi> 	data;

        public String toString() 
        {
            if (error != null) 
            {
                return error;
            }

            List<String> figiStrs = new ArrayList<String>();

            for (Figi figi : data) 
            {
                figiStrs.add(figi.toString());
            }

            return join("\n", figiStrs);
        }
    }

}
