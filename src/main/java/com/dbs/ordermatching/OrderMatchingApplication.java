package com.dbs.ordermatching;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.Instrument;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.CustodianRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;

@SpringBootApplication
public class OrderMatchingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingApplication.class, args);
	}
	
//	@Autowired
//	private BuyInstrumentRepository brepo;
//	
//	@Autowired
//	private SellInstrumentRepository srepo;
//	
//	@Bean
//	public void insertBuyData() {
//		
//	    brepo.save(new BuyInstrument(new Client("DBS001"),new Instrument("I001"),
//	    		100,100,true,new Date()));
//	    
//	    srepo.save(new SellInstrument(new Client("DBS001"),new Instrument("I001"),
//	    		100,50,true,new Date()));
//		
//	}
	
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
