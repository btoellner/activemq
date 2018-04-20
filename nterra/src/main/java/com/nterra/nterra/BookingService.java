package com.nterra.nterra;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

	public List<Flight> getFlights();
	
	public List getHotels();
	
	public List getCars();
	
	
}
