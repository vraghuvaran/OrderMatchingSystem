package com.dbs.ordermatching.restcontrollers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.models.BuyInstrument;
import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Result;
import com.dbs.ordermatching.services.BuySellInstrumentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/buyinstruments")
@CrossOrigin
@SecurityRequirement(name ="api")

public class BuyInstrumentsController {
	
	@Autowired
	private BuySellInstrumentService buysellinstrumentservice;
	
	@GetMapping("/getall/{clientid}")
	public ResponseEntity<Result> findBuysByClientId(@PathVariable String clientid) {
		
		Result result = new Result();
		try {
			List<BuyInstrument> list = this.buysellinstrumentservice.loadBuyInstrumentsByClientId(new Client(clientid));
			result.setStatus(true);
			result.setMessage("BuyInstruments found.");
			result.data = list;
			return ResponseEntity.status(HttpStatus.OK).body(result);	
		}catch (EntityNotFoundException e) {
			System.out.println("BuyInstruments not found error");
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
	
	
	@PostMapping
	public ResponseEntity<Result> saveBuyInstrument(@RequestBody BuyInstrument buyinstrument) {
		
		Result result = new Result();
		try {
			this.buysellinstrumentservice.updateBuyInstrument(buyinstrument);
			result.setStatus(true);
			result.setMessage("BuyInstrument saved successfully");
			return ResponseEntity.status(HttpStatus.OK).body(result);	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			result.setStatus(false);
			result.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(result);
		}
		
	}
	
	
	
	
	
	
	
}
