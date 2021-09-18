package com.dbs.ordermatching.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;

@Service
public class BuySellInstrumentService {

	@Autowired
	private BuyInstrumentRepository buyRepo;
	@Autowired
	private SellInstrumentRepository sellRepo;

	public List<BuyInstrument> loadBuyInstrumentsByClientId(Client clientid) throws IllegalArgumentException {
		try {
			return this.buyRepo.findAllByClientid(clientid);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public List<SellInstrument> loadSellInstrumentsByClientId(Client clientid) throws IllegalArgumentException {
		try {
			return this.sellRepo.findAllByClientid(clientid);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public boolean updateBuyInstrument(BuyInstrument buyinstrument) throws IllegalArgumentException{

		try {
			this.buyRepo.save(buyinstrument);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		return true;
	}
	
	public boolean updateSellInstrument(SellInstrument sellinstrument) throws IllegalArgumentException{

		try {
			this.sellRepo.save(sellinstrument);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		return true;
	}
	
	

}
