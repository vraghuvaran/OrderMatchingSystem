package com.dbs.ordermatching.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import com.dbs.ordermatching.utils.MyGenerator;

@Entity
public class ClientInstruments {
	
	@Id
	@GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.dbs.ordermatching.utils.MyGenerator")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="clientid")
	private Client clientid;

    @ManyToOne
    @JoinColumn(name="instrumentid")
	private Instrument instrumentid;
	
	private double quantity;
	
	public ClientInstruments() {
		
	}

	public ClientInstruments(Client clientid, Instrument instrumentid, double quantity) {
		super();
		this.clientid = clientid;
		this.instrumentid = instrumentid;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Client getClientid() {
		return clientid;
	}

	public void setClientid(Client clientid) {
		this.clientid = clientid;
	}

	public Instrument getInstrumentid() {
		return instrumentid;
	}

	public void setInstrumentid(Instrument instrumentid) {
		this.instrumentid = instrumentid;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ClientInstruments [id=" + id + ", clientid=" + clientid + ", instrumentid=" + instrumentid
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	

}
