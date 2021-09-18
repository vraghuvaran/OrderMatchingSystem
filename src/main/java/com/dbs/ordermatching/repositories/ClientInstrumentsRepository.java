package com.dbs.ordermatching.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.ClientInstruments;

public interface ClientInstrumentsRepository extends JpaRepository<ClientInstruments, String>{
	
	public List<ClientInstruments> findAllByClientid(Client clientid);
	
}
