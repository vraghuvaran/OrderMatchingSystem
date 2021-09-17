package com.dbs.ordermatching.restcontrollers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.Instrument;
import com.dbs.ordermatching.repositories.ClientRepository;
import com.dbs.ordermatching.repositories.CustodianRepository;
import com.dbs.ordermatching.repositories.InstrumentRepository;
import com.dbs.ordermatching.utils.DBInit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@RestController
@RequestMapping("/init")
public class DBInitRestController {
	
	@Autowired
	private CustodianRepository custodianRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired 
	private InstrumentRepository instrumentRepo;
	@GetMapping
	public void initialize() throws JsonMappingException, JsonProcessingException {
		System.out.println("database init running");
		if(DBInit.BUILD_DB) {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			/**
			 * 
			 *  custodian table
			 */
			List<Custodian> custodians = Arrays.asList(mapper.readValue(DBInit.CUSTODIANS, Custodian[].class));
			custodianRepo.saveAll(custodians);
			for (Custodian custodian: custodians) {
				System.out.println(custodian);
			}
			/**
			 *  Client table
			 */
			
			List<Client> clients = Arrays.asList(mapper.readValue(DBInit.CLIENTSJSON, Client[].class));
			clientRepo.saveAll(clients);
			for (Client client : clients) {
				System.out.println(client);
			}
			
			/**
			 *  Instrument table
			 */
			
			List<Instrument> instruments = Arrays.asList(mapper.readValue(DBInit.INSTRUMENTSJSON, Instrument[].class));
			instrumentRepo.saveAll(instruments);
			for (Instrument instrument : instruments) {
				System.out.println(instrument);
			}
			
		}
	}
	
}
