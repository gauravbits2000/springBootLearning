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
		
		//authenticationService.generateApiKey();
		
		
		List<Job> jobs = new ArrayList<Job>();
		
/*		 jobs.add(app.createJob("ID_WERTPAPIER", "851399").currency("USD"));
	     jobs.add(app.createJob("ID_BB_UNIQUE", "EQ0010080100001000").currency("USD"));
	     jobs.add(app.createJob("ID_SEDOL", "2005973").micCode("EDGX").currency("USD"));*/
	     
	     jobs.add(app.createJob("ID_ISIN", "US4592001014"));

		
	     
       //List<JobResult> jobResults = client.getBBGData(jobs);
       
       
	     
		String request ="";		
		//client.getBBGData("ID_CUSIP", "123456789");
		clientRestBased.getBBGData("ID_CUSIP", "123456789");

 /*       int i = 0;
        for (JobResult result : jobResults) {
            i+=1;
            System.out.println(String.format("Query #%d results\n", i));
            System.out.println(result.toString());
            System.out.println("\n");
        }*/
	     

		
		
		//authenticationService.logout();
		System.exit(0);
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
