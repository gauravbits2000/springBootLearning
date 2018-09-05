package com.learning.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class BBGServiceStarter implements CommandLineRunner
{
	@Autowired
	private BBGCache cache;
	
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
	
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Inside Run method");
		
		BBGServiceStarter app = new BBGServiceStarter();
		
		cache.initializeCache();
		


	}
	

}
