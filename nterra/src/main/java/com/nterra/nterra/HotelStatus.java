package com.nterra.nterra;

public class HotelStatus {

	boolean isAvailable;
	Integer carId;
	
	
	
	public HotelStatus(boolean isAvailable, Integer carId) {
		super();
		this.isAvailable = isAvailable;
		this.carId = carId;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Integer getFlightid() {
		return carId;
	}
	public void setFlightid(Integer flightid) {
		this.carId = flightid;
	}
	
}
