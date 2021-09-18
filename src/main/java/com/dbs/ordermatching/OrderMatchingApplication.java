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
import com.dbs.ordermatching.models.TradeHistory;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.CustodianRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;
import com.dbs.ordermatching.repositories.TradeHistoryRepository;

@SpringBootApplication
public class OrderMatchingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingApplication.class, args);
	}
	
	@Autowired
	private BuyInstrumentRepository brepo;
	
	@Autowired
	private SellInstrumentRepository srepo;
	
	@Autowired 
	private TradeHistoryRepository tradeHistoryRepo;
	
	@Bean
	public void insertBuyData() {
		
		Custodian sellerCust = new Custodian("CS002");
		Client sellerClient = new Client("DBS005");
		Instrument instrument = new Instrument("I001");
		BuyInstrument buy = new BuyInstrument(sellerClient,instrument,
	    		100,100,true,new Date());
	    brepo.save(buy);
	    
	    Custodian buyerCust = new Custodian("CS001");
	    Client buyerClient = new Client("DBS001");
	    SellInstrument sell = new SellInstrument(buyerClient,instrument,
	    		100,100,true,new Date());
	    srepo.save(sell);
	    
	    tradeHistoryRepo.save(new TradeHistory(
	    		sellerCust, buyerCust, 
	    		sellerClient, buyerClient, 
	    		instrument, 
	    		buy.getPrice(), buy.getQuantity(), 
	    		new Date()));
		
//	    tradeHistoryRepo.save(new TradeHistory(new Custodian("CS001"), new Custodian("CS001"), new Client("DBS002"), new Client("DBS001"), new Instrument("I001"), 100, 50, new Date()));
			
	}
	
	@Autowired
	private CustodianRepository repo;
	
	
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
