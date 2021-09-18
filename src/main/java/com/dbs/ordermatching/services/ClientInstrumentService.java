package com.dbs.ordermatching.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.ClientInstruments;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.ClientInstrumentsRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;

@Service
public class ClientInstrumentService {

	@Autowired
	private ClientInstrumentsRepository clientInstrumentRepo;
	

	public List<ClientInstruments> loadBuyInstrumentsByClientId(Client clientid) throws IllegalArgumentException {
		try {
			return this.clientInstrumentRepo.findAllByClientid(clientid);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public boolean updateBuyInstrument(ClientInstruments clientIntrument) throws IllegalArgumentException{
		
		try {
			this.clientInstrumentRepo.save(clientIntrument);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		return true;
	}
	

}
