package com.nterra.nterra;

public class CarStatus {

	boolean isAvailable;
	Integer hotelId;
	
	
	
	public CarStatus(boolean isAvailable, Integer hotelId) {
		super();
		this.isAvailable = isAvailable;
		this.hotelId = hotelId;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Integer getFlightid() {
		return hotelId;
	}
	public void setFlightid(Integer flightid) {
		this.hotelId = flightid;
	}
	
}
