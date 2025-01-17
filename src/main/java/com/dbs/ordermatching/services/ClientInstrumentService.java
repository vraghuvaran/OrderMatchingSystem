package com.dbs.ordermatching.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.ClientInstrument;
import com.dbs.ordermatching.models.ClientInstrumentid;
import com.dbs.ordermatching.models.ClientInstruments;
import com.dbs.ordermatching.models.Instrument;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.ClientInstrumentRepository;
import com.dbs.ordermatching.repositories.ClientInstrumentsRepository;
import com.dbs.ordermatching.repositories.SellInstrumentRepository;

@Service
public class ClientInstrumentService {

	
	@Autowired
	private ClientInstrumentRepository clientInstrumentRepo;
	
	@Autowired
	private ClientInstrumentsRepository clientInstrumentsRepo;
	
	
	
	
//	public List<ClientInstrument> loadAllClientInstrumentByClientId(Client clientid) throws IllegalArgumentException {
//		try {
//			return this.clientInstrumentRepo.findAllByClientinstrumentidClient(clientid);
//		} catch (IllegalArgumentException e) {
//			throw new IllegalArgumentException(e);
//		}
//	}
//
//	public boolean updateClientInstrument(ClientInstrument clientIntrument) throws IllegalArgumentException{
//		
//		try {
//			this.clientInstrumentRepo.save(clientIntrument);
//		} catch (IllegalArgumentException e) {
//			throw new IllegalArgumentException(e);
//		}
//		return true;
//	}
//	
	


	public List<ClientInstruments> loadAllBuyInstrumentsByClientId(Client clientid) throws IllegalArgumentException {
		try {
			return this.clientInstrumentsRepo.findAllByClientid(clientid);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public ClientInstruments loadClientInstrumersByCliesntIdAndInstrumentId(Client clientid,Instrument instrumentid) throws IllegalArgumentException {
		try {
			Optional<ClientInstruments> clientInstruments= this.clientInstrumentsRepo.findById(String.format("%s%s%s", clientid.getClientid(),"###" ,instrumentid.getInstrumentid()));
			return clientInstruments.orElseThrow(()->{	
				return new EntityNotFoundException(String.format("Client with id %s has no Instrument with id %s",clientid.getClientid(),instrumentid.getInstrumentid()));
			});
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public boolean updateClientInstrumenets(ClientInstruments clientIntrument) throws IllegalArgumentException{
		
		try {
			if(clientIntrument.getQuantity()<=0) this.clientInstrumentsRepo.delete(clientIntrument);
			this.clientInstrumentsRepo.save(clientIntrument);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		return true;
	}
	

}
