package com.dbs.ordermatching.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dbs.ordermatching.utils.CustodianDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class Client {
	
	@Id
	private String clientid;
	
	@Column(unique = true)
	private String clientname;
	
	@OneToOne
	@JoinColumn(name="custodianid")
	@JsonDeserialize(using = CustodianDeserializer.class)  
	private Custodian custodianid;
	
	private double transactionlimit;
//	
	private double balance;
	
	public Client() {
		
	}

	public Client(String clientid, String clientname, Custodian custodianid, double transactionlimit, double balance) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.custodianid = custodianid;
		this.transactionlimit = transactionlimit;
		this.balance = balance;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public Custodian getCustodianid() {
		return custodianid;
	}

	public void setCustodianid(Custodian custodianid) {
		this.custodianid = custodianid;
	}

	public double getTransactionlimit() {
		return transactionlimit;
	}

	public void setTransactionlimit(double transactionlimit) {
		this.transactionlimit = transactionlimit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", clientname=" + clientname + ", custodianid=" + custodianid
				+ ", transactionlimit=" + transactionlimit + ", balance=" + balance + "]";
	}	

}





/**
 * USE THIS CLIENT CODE WHILE DBINIT because json serializer failing to serialize nested object custodian 
 */

/**
 * package com.dbs.ordermatching.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Client implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	private String clientid;
	
	@Column(unique = true)
	private String clientname;
	
//	@OneToOne
//	@JoinColumn(name="custodianid")
	private String custodianid;
	
	public Client(String clientid, String clientname, String custodianid, double transactionlimit, double balance) {
	super();
	this.clientid = clientid;
	this.clientname = clientname;
	this.custodianid = custodianid;
	this.transactionlimit = transactionlimit;
	this.balance = balance;
}


	public String getCustodianid() {
		return custodianid;
	}


	public void setCustodianid(String custodianid) {
		this.custodianid = custodianid;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private double transactionlimit;
//	
	private double balance;
	
	public Client() {
		
	}


	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}


	public double getTransactionlimit() {
		return transactionlimit;
	}

	public void setTransactionlimit(double transactionlimit) {
		this.transactionlimit = transactionlimit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", clientname=" + clientname + ", custodianid=" + custodianid
				+ ", transactionlimit=" + transactionlimit + ", balance=" + balance + "]";
	}


	
	
	
	

}

 */


