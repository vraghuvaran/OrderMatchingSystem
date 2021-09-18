package com.dbs.ordermatching.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.SellInstrument;
import com.dbs.ordermatching.models.TradeHistory;
import com.dbs.ordermatching.repositories.BuyInstrumentRepository;
import com.dbs.ordermatching.repositories.TradeHistoryRepository;

@Service
public class TradeHistoryService {

	@Autowired
	private TradeHistoryRepository tradeHistoryRepo;

	@Autowired
	private BuySellInstrumentService buySellInstrumentService;
	@Autowired
	private BuyInstrumentRepository buySellInstrumentRepo;
	
	

	public List<TradeHistory> loadAllTradeHistoryById(Custodian custodianId) throws IllegalArgumentException {
		try {
			return this.tradeHistoryRepo.findAllBySendercustodianidOrReceivercustodianid(custodianId, custodianId);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public boolean insertTradeHistory(TradeHistory tradeHistory) {
		if (this.tradeHistoryRepo.findById(tradeHistory.getId()).isPresent())
			return false;
		try {
			this.tradeHistoryRepo.save(tradeHistory);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public boolean insertAllTradeHistory(List<TradeHistory> tradeHistorys) throws EntityExistsException {
		tradeHistorys.forEach(trade -> {
			if (this.tradeHistoryRepo.findById(trade.getId()).isPresent())
				throw new EntityExistsException("Trade History with id " + trade.getId() + " already Exists");
		});
		try {
			this.tradeHistoryRepo.saveAll(tradeHistorys);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public long fetchCountofBuyTradesById(Custodian custodianId) throws IllegalArgumentException {
		try {
			return this.tradeHistoryRepo.countBySendercustodianid(custodianId);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public long fetchCountofSellTradesById(Custodian custodianId) throws IllegalArgumentException {
		try {
			return this.tradeHistoryRepo.countByReceivercustodianid(custodianId);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public void tradematchingEngine(String id, boolean isBuy) throws Exception {
		
			if (isBuy) {
				BuyInstrument buyInstrument = buySellInstrumentService.loadBuyInstrumentById(id);
				Client client = buyInstrument.clientid;
				BigDecimal totalTransaction = new  BigDecimal(buyInstrument.getPrice()*buyInstrument.getQuantity());
				if(client.getBalance().compareTo(totalTransaction)==-1) {
					throw new Exception("Insufficient Transaction Limit");
				}
			SellInstrument sellInstrument= 	buySellInstrumentRepo.findSellInstrumentToTrade(client, buyInstrument.getPrice() ,buyInstrument.getInstrumentid() ).get(0);
				
			System.out.println(sellInstrument);
			} else {
				BuyInstrument sellInstrument = buySellInstrumentService.loadBuyInstrumentById(id);
				Client client = sellInstrument.clientid;
				BigDecimal totalTransaction = new  BigDecimal(sellInstrument.getPrice()*sellInstrument.getQuantity());
				if(client.getBalance().compareTo(totalTransaction)==-1) {
					throw new Exception("Insufficient Transaction Limit");
				}
			BuyInstrument buyInstrument= 	buySellInstrumentRepo.findBuyInstrumentToTrade(client, sellInstrument.getPrice() ,sellInstrument.getInstrumentid() ).get(0);
				
			System.out.println(buyInstrument);

			}

		
	}

}
