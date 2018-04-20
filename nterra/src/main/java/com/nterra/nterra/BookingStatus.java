package com.nterra.nterra;

public class BookingStatus {
	private int bookingId;

	private boolean isAvailable;
	
	private FlightStatus flightStatus;
	private HotelStatus hotelStatus;
	private CarStatus carStatus;
	
	public BookingStatus(int bookingId, boolean isAvailable, FlightStatus flightStatus, HotelStatus hotelStatus,
			CarStatus carStatus) {
		super();
		this.bookingId = bookingId;
		this.isAvailable = isAvailable;
		this.flightStatus = flightStatus;
		this.hotelStatus = hotelStatus;
		this.carStatus = carStatus;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public FlightStatus getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}
	public HotelStatus getHotelStatus() {
		return hotelStatus;
	}
	public void setHotelStatus(HotelStatus hotelStatus) {
		this.hotelStatus = hotelStatus;
	}
	public CarStatus getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(CarStatus carStatus) {
		this.carStatus = carStatus;
	}
	
	
	
	
}
