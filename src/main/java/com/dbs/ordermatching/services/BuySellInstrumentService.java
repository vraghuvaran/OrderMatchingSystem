package com.dbs.ordermatching.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;

@Service
public class BuySellInstrumentService {
	
	@Autowired
	private BuyInstrumentRepository buyRepo;
	@Autowired
	private SellInstrumentRepository sellRepo;


	
	public List<BuyInstrument> loadBuyInstrumentsByClientId(String  clientid) {
		try {
			return  this.buyRepo.findAllByClientid(clientid);
		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}

	
	public List<SellInstrument> loadSellInstrumentsByClientId(String  clientid) {
		try {
			return  this.sellRepo.findAllByClientid(clientid);
		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
	
}
