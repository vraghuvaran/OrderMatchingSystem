package com.dbs.ordermatching.models;

public class AuthenticationRequest {
      
	private String custodianid;
	
	private String password;
	
	
	public AuthenticationRequest() {
		
	}


	public AuthenticationRequest(String custodianid, String password) {
		super();
		this.custodianid = custodianid;
		this.password = password;
	}


	public String getCustodianid() {
		return custodianid;
	}


	public void setCustodianid(String custodianid) {
		this.custodianid = custodianid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "AuthenticationRequest [custodianid=" + custodianid + ", password=" + password + "]";
	}


    
}
