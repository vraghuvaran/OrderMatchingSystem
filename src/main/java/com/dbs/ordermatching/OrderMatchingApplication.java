package com.dbs.ordermatching;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.Instrument;
import com.dbs.ordermatching.models.LastTradeHistory;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.models.TradeHistory;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.CustodianRepository;
import com.dbs.ordermatching.repositories.LastTradeHistoryRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;
import com.dbs.ordermatching.repositories.TradeHistoryRepository;
import com.dbs.ordermatching.restcontrollers.CustodianController;


@SpringBootApplication
public class OrderMatchingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingApplication.class, args);
	}
	
	@Autowired
	private CustodianRepository repo1;
	
	@PostConstruct
	public void initialize() {
		System.out.println("initialize");
		List<Custodian> accs = Stream.of(
				new Custodian("raghuvaran", "Bank of America",encoder().encode("raghuvaran") ),
				new Custodian("raghuvaran1", "Bank of China", encoder().encode("raghuvaran1")),
				new Custodian("raghuvaran2", "Canadian Bank",encoder().encode("raghuvaran2")),
				new Custodian("raghuvaran3","The Swiss Group", encoder().encode("raghuvaran3")),
				new Custodian("raghuvaran5","State Bank of india", encoder().encode("password"))).collect(Collectors.toList());

		repo1.saveAll(accs);

	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Autowired
	private BuyInstrumentRepository brepo;
	
	@Autowired
	private SellInstrumentRepository srepo;
	
	@Autowired 
	private TradeHistoryRepository tradeHistoryRepo;
	
	
	@Autowired 
	private LastTradeHistoryRepository lastTradeRepo;
	
	
	
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
	    
	    TradeHistory trade = new TradeHistory(
	    		sellerCust, buyerCust, 
	    		sellerClient, buyerClient, 
	    		instrument, 
	    		buy.getPrice(), buy.getQuantity(), 
	    		new Date());
	    tradeHistoryRepo.save(trade);

	    lastTradeRepo.save(new LastTradeHistory(buyerCust.getCustodianid(), trade, new Date()));

	    lastTradeRepo.save(new LastTradeHistory(sellerCust.getCustodianid(), trade, new Date()));
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
