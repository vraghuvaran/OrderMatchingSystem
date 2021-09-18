package com.dbs.ordermatching.restcontrollers;

import java.util.ArrayList;
import java.util.List;

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
import com.dbs.ordermatching.models.Result;
import com.dbs.ordermatching.models.TradeHistory;
import com.dbs.ordermatching.services.TradeHistoryService;


@RestController
@RequestMapping("/trade-history")
@CrossOrigin
public class TradeHistoryController {
	
	@Autowired
	private TradeHistoryService tradeHistoryService;
	
	@GetMapping("/{custodianId}")
	public ResponseEntity<Result> findAllClientsByCustodianId(@PathVariable String custodianId) {
		Result result = new Result();
		try { 
			List<TradeHistory> tradehistory = this.tradeHistoryService.loadAllTradeHistoryById(new Custodian(custodianId));
			result.setStatus(true);
			result.setMessage("Trades found");
			result.data = tradehistory;
			return ResponseEntity.status(HttpStatus.OK).body(result);			
		}catch (EntityNotFoundException e) {
			System.out.println("Trades not found error");
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
