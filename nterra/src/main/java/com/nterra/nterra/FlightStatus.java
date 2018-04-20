package com.nterra.nterra;

public class FlightStatus {

	boolean isAvailable;
	Integer flightid;
	
	
	
	public FlightStatus(boolean isAvailable, Integer flightid) {
		super();
		this.isAvailable = isAvailable;
		this.flightid = flightid;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Integer getFlightid() {
		return flightid;
	}
	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}
	
}
