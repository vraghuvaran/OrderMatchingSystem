package com.dbs.ordermatching.models;

public class AuthenticationRequest {
      
	private String custodianid;
	
	private String password;
	
	
	public AuthenticationRequest() {
		
	}


	public AuthenticationRequest(String username, String password) {
		super();
		this.custodianid = username;
		this.password = password;
	}


	public String getUsername() {
		return custodianid;
	}


	public void setUsername(String username) {
		this.custodianid = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + custodianid + ", password=" + password + "]";
	}
	
    
}
