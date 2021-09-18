package com.dbs.ordermatching.services;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.TradeHistory;
import com.dbs.ordermatching.repositories.TradeHistoryRepository;

@Service
public class TradeHistoryService {
	
	@Autowired
	private TradeHistoryRepository tradeHistoryRepo;
	
	public List<TradeHistory>  loadAllTradeHistoryById(Custodian custodianId ) throws IllegalArgumentException{
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
	
	public boolean insertAllTradeHistory(List<TradeHistory> tradeHistorys)
	throws EntityExistsException
	{
		tradeHistorys.forEach(trade -> {
			if(this.tradeHistoryRepo.findById(trade.getId()).isPresent()) 
					throw new EntityExistsException("Trade History with id "+trade.getId()+" already Exists");
		});
		try {
			this.tradeHistoryRepo.saveAll(tradeHistorys);
		}catch(IllegalArgumentException e )
		{
			return false;
		}
		return true;
	}
	
	public long fetchCountofBuyTradesById(Custodian custodianId ) throws IllegalArgumentException{
		try {
			return  this.tradeHistoryRepo.countBySendercustodianid(custodianId);
		}catch(IllegalArgumentException e )
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}
	public long fetchCountofSellTradesById(Custodian custodianId ) throws IllegalArgumentException{
		try {
			return  this.tradeHistoryRepo.countByReceivercustodianid(custodianId);
		}catch(IllegalArgumentException e )
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	
}
