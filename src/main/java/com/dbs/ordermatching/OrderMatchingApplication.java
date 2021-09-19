package com.dbs.ordermatching;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dbs.ordermatching.repositories.TradeHistoryRepository;





@SpringBootApplication
public class OrderMatchingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingApplication.class, args);
	}

	
//	@PostConstruct
//	public void initialize() {
//		System.out.println("initialize");
//		List<Custodian> accs = Stream.of(
//				new Custodian("raghuvaran", "Bank of America",encoder().encode("raghuvaran") ),
//				new Custodian("raghuvaran1", "Bank of China", encoder().encode("raghuvaran1")),
//				new Custodian("raghuvaran2", "Canadian Bank",encoder().encode("raghuvaran2")),
//				new Custodian("raghuvaran3","The Swiss Group", encoder().encode("raghuvaran3")),
//				new Custodian("raghuvaran5","State Bank of india", encoder().encode("password"))).collect(Collectors.toList());
//
//		repo1.saveAll(accs);
//
//	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private TradeHistoryRepository repo ;
	
	
}
