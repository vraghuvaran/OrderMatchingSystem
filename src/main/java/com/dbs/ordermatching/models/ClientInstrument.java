package com.dbs.ordermatching.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ClientInstrument {
	
	@EmbeddedId
	private ClientInstrumentid clientinstrumentid;
	
	
	private double quantity;
	
	public ClientInstrument() {
		
	}

	public ClientInstrument(ClientInstrumentid id, double quantity) {
		super();
		this.clientinstrumentid = id;
		this.quantity = quantity;
	}



	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	
	

}
