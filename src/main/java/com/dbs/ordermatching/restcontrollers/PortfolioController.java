package com.dbs.ordermatching.restcontrollers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Result;
import com.dbs.ordermatching.services.BuySellInstrumentService;
import com.dbs.ordermatching.services.ClientService;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin
public class PortfolioController {
	
	@Autowired
	private ClientService clientService ;
	
	@Autowired
	private BuySellInstrumentService buySellService ;
	
	
	
	@GetMapping("/{clientid}/{custodianid}")
	public ResponseEntity<Result> fetchProfileData(@PathVariable String clientid,@PathVariable String custodianid) {
		Result result = new Result();
		try { 
			
			Client client = this.clientService.findClientById(clientid);
			client.getCustodianid().setPassword("");
			
			
			result.setStatus(true);
			result.setMessage("Client found");
			result.data = client;
			return ResponseEntity.status(HttpStatus.OK).body(result);			
		}catch (EntityNotFoundException e) {
			System.out.println("Client not found error");
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
