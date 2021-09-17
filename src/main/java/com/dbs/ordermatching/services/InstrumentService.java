package com.dbs.ordermatching.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.ordermatching.models.Instrument;
import com.dbs.ordermatching.repositories.InstrumentRepository;

@Service
public class InstrumentService {
	
	@Autowired
	private InstrumentRepository instructionRepo;
	
	public Instrument loadBuyInstrumentById(String  instrumentId) {
		try {
			
			Optional<Instrument> cust = this.instructionRepo.findById(instrumentId);
			return cust.orElseThrow(()->{	
				return new EntityNotFoundException("Instrument with  "+instrumentId+ " does not exist");
			});
			
		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
}
