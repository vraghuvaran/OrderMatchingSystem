package com.dbs.ordermatching.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.dbs.ordermatching.utils.MyGenerator;

@Entity
public class ClientInstruments {
	
	@Id
	@GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.dbs.ordermatching.utils.MyGenerator")
	private String id;
	
	
	private Client clientid;
	
	private Instrument instrumentid;
	
	private double quantity;
	
	

}
