package com.dbs.ordermatching.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.dbs.ordermatching.utils.MyGenerator;

@Entity
public class SellInstrument {
	
	@Id
	@GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.dbs.ordermatching.utils.MyGenerator")
	public String id;
    
    @ManyToOne
    @JoinColumn(name="clientid")
	public Client clientid;
	
    @ManyToOne
    @JoinColumn(name="instrumentid")
	public Instrument instrumentid;

	public double price;
	
	public double quantity;
	
	public Boolean isactive;
	
	public LocalDate createdate;

	public SellInstrument() {
		// TODO Auto-generated constructor stub
	}

	public SellInstrument(Client clientid, Instrument instrumentid, double price, double quantity,
			Boolean isactive, LocalDate createdate) {
		super();
		
		this.clientid = clientid;
		this.instrumentid = instrumentid;
		this.price = price;
		this.quantity = quantity;
		this.isactive = isactive;
		this.createdate = createdate;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "SellInstrument [id=" + id + ", clientid=" + clientid + ", instrumentid=" + instrumentid + ", price="
				+ price + ", quantity=" + quantity + ", isactive=" + isactive + ", createdate=" + createdate + "]";
	}

	
}
