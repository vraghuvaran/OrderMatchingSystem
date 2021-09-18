package com.dbs.ordermatching.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.ClientInstrument;
import com.dbs.ordermatching.models.ClientInstrumentid;
import com.dbs.ordermatching.models.ClientInstruments;
import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.TradeHistory;

public interface ClientInstrumentRepository extends JpaRepository<ClientInstrument, ClientInstrumentid>{
	
	public List<ClientInstrument> findAllByClientinstrumentidClient(Client clientid);
	
	
//	@Query("select u from ClientInstrument u where u.clientinstrumentid = :clientinstrumentid")
//	  List<ClientInstrument> findAllByClientinstrumentidClient(@Param("clientinstrumentid") ClientInstrumentid clientinstrumentid);

}
