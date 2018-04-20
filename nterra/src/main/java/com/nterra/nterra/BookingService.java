package com.nterra.nterra;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

	public List<Flight> getFlights();
	
	public List getHotels();
	
	public List getCars();

	public void handleFlightBooking(Integer flightId);

	public void handleHotelBooking(Integer hotelId);
	
	public void handleCarBooking(Integer carId);
	
	
}
