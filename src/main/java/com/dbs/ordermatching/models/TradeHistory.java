package com.dbs.ordermatching.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.dbs.ordermatching.utils.MyGenerator;

@Entity
public class TradeHistory {
	
	@Id
	@GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.dbs.ordermatching.utils.MyGenerator")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="sendercustodianid")
	private Custodian sendercustodianid;
	
	@ManyToOne
	@JoinColumn(name="receivercustodianid")
	private Custodian receivercustodianid;
	
	@ManyToOne
	@JoinColumn(name="senderclientid")
	private Client senderclientid;
	
	@ManyToOne
	@JoinColumn(name="receiverclientid")
	private Client receiverclientid;
	
	@ManyToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrumentid;
	
	private double price;
	
	private double quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdat;
	
    public TradeHistory() {
    	
    }

	public TradeHistory(Custodian sendercustodianid, Custodian receivercustodianid, Client senderclientid,
			Client receiverclientid, Instrument instrumentid, double price, double quantity, Date createdat) {
		super();
		this.sendercustodianid = sendercustodianid;
		this.receivercustodianid = receivercustodianid;
		this.senderclientid = senderclientid;
		this.receiverclientid = receiverclientid;
		this.instrumentid = instrumentid;
		this.price = price;
		this.quantity = quantity;
		this.createdat = createdat;
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Custodian getSendercustodianid() {
		return sendercustodianid;
	}

	public void setSendercustodianid(Custodian sendercustodianid) {
		this.sendercustodianid = sendercustodianid;
	}

	public Custodian getReceivercustodianid() {
		return receivercustodianid;
	}

	public void setReceivercustodianid(Custodian receivercustodianid) {
		this.receivercustodianid = receivercustodianid;
	}

	public Client getSenderclientid() {
		return senderclientid;
	}

	public void setSenderclientid(Client senderclientid) {
		this.senderclientid = senderclientid;
	}

	public Client getReceiverclientid() {
		return receiverclientid;
	}

	public void setReceiverclientid(Client receiverclientid) {
		this.receiverclientid = receiverclientid;
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

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	@Override
	public String toString() {
		return "TradeHistory [sendercustodianid=" + sendercustodianid + ", receivercustodianid=" + receivercustodianid
				+ ", senderclientid=" + senderclientid + ", receiverclientid=" + receiverclientid + ", instrumentid="
				+ instrumentid + ", price=" + price + ", quantity=" + quantity + ", createdat=" + createdat + "]";
	}
    
   
	
	
	

}
