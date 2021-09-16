package com.dbs.ordermatching.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instrument {
	
	@Id
	private String instrumentid;
	
	@Column(unique = true)
	private String instrumentname;
	
	private double facevalue;
	
	private double minquanity;
	
	private LocalDate expiry;
	
	public Instrument() {
		
	}

	public Instrument(String instrumentid, String instrumentname, double facevalue, double minquanity,
			LocalDate expiry) {
		super();
		this.instrumentid = instrumentid;
		this.instrumentname = instrumentname;
		this.facevalue = facevalue;
		this.minquanity = minquanity;
		this.expiry = expiry;
	}

	public String getInstrumentid() {
		return instrumentid;
	}

	public void setInstrumentid(String instrumentid) {
		this.instrumentid = instrumentid;
	}

	public String getInstrumentname() {
		return instrumentname;
	}

	public void setInstrumentname(String instrumentname) {
		this.instrumentname = instrumentname;
	}

	public double getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(double facevalue) {
		this.facevalue = facevalue;
	}

	public double getMinquanity() {
		return minquanity;
	}

	public void setMinquanity(double minquanity) {
		this.minquanity = minquanity;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "Instrument [instrumentid=" + instrumentid + ", instrumentname=" + instrumentname + ", facevalue="
				+ facevalue + ", minquanity=" + minquanity + ", expiry=" + expiry + "]";
	}
	
	

}
