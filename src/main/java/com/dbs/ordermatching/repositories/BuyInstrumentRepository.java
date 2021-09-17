package com.dbs.ordermatching.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;

public interface BuyInstrumentRepository extends JpaRepository<BuyInstrument, String>{
	
	public List<BuyInstrument> findAllByClientid(String clientid);
	
}
