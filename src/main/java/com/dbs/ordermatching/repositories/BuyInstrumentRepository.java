package com.dbs.ordermatching.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.Instrument;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.models.TradeHistory;

public interface BuyInstrumentRepository extends JpaRepository<BuyInstrument, String>{
	
	public List<BuyInstrument> findAllByClientid(Client clientid);
	

	@Query("select u from BuyInstrument u where u.clientid != :clientid and u.price = :price and u.instrumentid =:instrumentid and u.isactive =true order by u.createdate asc")
	public List<BuyInstrument> findBuyInstrumentToTrade(Client clientid,double  price, Instrument instrumentid);
	

	@Query("select u from SellInstrument u where u.clientid != :clientid and u.price = :price and u.instrumentid =:instrumentid and u.isactive =true order by u.createdate asc")
	public List<SellInstrument> findSellInstrumentToTrade(Client clientid,double  price, Instrument instrumentid);
	
	
}
