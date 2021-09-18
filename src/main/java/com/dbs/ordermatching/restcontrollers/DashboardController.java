package com.dbs.ordermatching.restcontrollers;

import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.LastTradeHistory;
import com.dbs.ordermatching.models.Result;
import com.dbs.ordermatching.services.ClientService;
import com.dbs.ordermatching.services.LastTradeHistoryService;
import com.dbs.ordermatching.services.TradeHistoryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
@SecurityRequirement(name ="api")

public class DashboardController {
	@Autowired
	private TradeHistoryService tradeHistoryService;
	
	@Autowired
	private LastTradeHistoryService lastTradeHistoryService;
	
	@Autowired
	private ClientService clientService ;


	@GetMapping("/{custodianid}")
	public ResponseEntity<Result> fetchProfileData(@PathVariable String custodianid) {
		Result result = new Result();
		try { 
			
			long clientsCount = this.clientService.fetchCountofClientById(new Custodian(custodianid));
			LastTradeHistory lastTrade = this.lastTradeHistoryService.loadById(custodianid);
 			long sellTrades  = this.tradeHistoryService.fetchCountofSellTradesById(new Custodian(custodianid));

 			long buyTrades  = this.tradeHistoryService.fetchCountofBuyTradesById(new Custodian(custodianid));
			
 			long totalTrades = sellTrades + buyTrades;
 			
 			
			result.setStatus(true);
			result.setMessage("Found Dashboard data");
			result.data = Map.of(
					"clientsCount",clientsCount,
					"sellTrades",sellTrades,
					"buyTrades",buyTrades,
					"totalTrades",totalTrades,
					"lastTrade",lastTrade
					);

			return ResponseEntity.status(HttpStatus.OK).body(result);			
		}catch (EntityNotFoundException e) {
			System.out.println("Not found error");
			result.setStatus(false);
			result.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(result);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			result.setStatus(false);
			result.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(result);
		}
	}
	
	

}
