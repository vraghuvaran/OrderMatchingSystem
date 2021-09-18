package com.dbs.ordermatching.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LastTradeHistory {
	
	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name="tradehistoryid")
	private TradeHistory tradehistory;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdat;
	
	
	public LastTradeHistory() {
		// TODO Auto-generated constructor stub
	}


	public LastTradeHistory(String id, TradeHistory tradehistory, Date createdat) {
		super();
		this.id = id;
		this.tradehistory = tradehistory;
		this.createdat = createdat;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public TradeHistory getTradehistory() {
		return tradehistory;
	}


	public void setTradehistory(TradeHistory tradehistory) {
		this.tradehistory = tradehistory;
	}


	public Date getCreatedat() {
		return createdat;
	}


	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


	@Override
	public String toString() {
		return "LastTradeHistory [id=" + id + ", tradehistory=" + tradehistory + ", createdat=" + createdat + "]";
	}
	
	
	
	
	
	
}
