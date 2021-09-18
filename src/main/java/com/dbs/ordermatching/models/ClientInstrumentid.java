package com.dbs.ordermatching.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class ClientInstrumentid implements Serializable{
	

	@OneToOne
	@JoinColumn(name="clientid")
	private Client client;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	
	public ClientInstrumentid() {
		// TODO Auto-generated constructor stub
	}

	public ClientInstrumentid(Client client, Instrument instrument) {
		super();
		this.client = client;
		this.instrument = instrument;
	}

	public ClientInstrumentid(Client clientid) {
		// TODO Auto-generated constructor stub
		this.client = clientid;
		this.instrument = null;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((client == null) ? 0 : client.hashCode());
	        result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
	        return result;
	    }
	    @Override
	    public boolean equals(Object obj) {
	    	System.out.println("Called");
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        ClientInstrumentid other = (ClientInstrumentid) obj;
	        if (client == null) {
	            if (other.client != null)
	                return false;
	        } else if (!client.getClientid().equals(other.client.getClientid().toString()))
	            return false;
	        if (instrument == null) {
	            if (other.instrument != null)
	                return false;
	        } else if (!instrument.equals(other.instrument))
	            return false;
	        return true;
	    }

		@Override
		public String toString() {
			return "ClientInstrumentid [client=" + client + ", instrument=" + instrument + "]";
		}
	    
	    
	
}
