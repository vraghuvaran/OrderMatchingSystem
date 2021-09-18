package com.dbs.ordermatching.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.ordermatching.models.TradeHistory;
import com.dbs.ordermatching.repositories.TradeHistoryRepository;

@Service
public class TradeHistoryService {
	
	@Autowired
	private TradeHistoryRepository tradeHistoryRepo;
	
	public List<TradeHistory>  loadAllTradeHistoryById(String custodianId ) throws IllegalArgumentException{
		try {
			return  this.tradeHistoryRepo.findAllBySendercustodianidOrReceivercustodianid(custodianId,custodianId);
		}catch(IllegalArgumentException e )
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public boolean insertTradeHistory(TradeHistory tradeHistory)
	{
		if(this.tradeHistoryRepo.findById(tradeHistory.getId()).isPresent())
			return false;
		try {
			this.tradeHistoryRepo.save(tradeHistory);
		}catch(IllegalArgumentException e )
		{
			return false;
		}
		return true;
	}
	
//	public boolean insertAllTradeHistory(List<TradeHistory> tradeHistorys)
//	{
//		
//		
//		if(this.tradeHistoryRepo.findById(tradeHistorys.getId()).isPresent())
//			return false;
//		try {
//			this.tradeHistoryRepo.save(tradeHistorys);
//		}catch(IllegalArgumentException e )
//		{
//			return false;
//		}
//		return true;
//	}
//	
	
}
