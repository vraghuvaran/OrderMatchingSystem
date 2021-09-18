package com.dbs.ordermatching.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.SellInstrument;

public interface SellInstrumentRepository extends JpaRepository<SellInstrument, String>{

	List<SellInstrument> findAllByClientid(Client clientid);

}
