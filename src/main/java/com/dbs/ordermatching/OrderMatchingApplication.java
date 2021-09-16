package com.dbs.ordermatching;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.repositories.CustodianRepository;

@SpringBootApplication
public class OrderMatchingApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingApplication.class, args);
		
		
		
	}
	
//	@Autowired
//	private CustodianRepository repo;
//	
//	
//	@Bean
//	public void insertProductData()
//	{
//		
//        Custodian cust = new Custodian("american_bank","");
//
//        Custodian cust1 = new Custodian("americannn_bank","");
//
//		repo.save(cust);
//		repo.save(cust1);
//		
//		
//	}

}
