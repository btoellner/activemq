package com.nterra.nterra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaulfBookingService implements BookingService {

	private UniversalQueueRequester universalQueueRequester;
	
	@Autowired
	public DefaulfBookingService(UniversalQueueRequester universalQueueRequester) {
		this.universalQueueRequester = universalQueueRequester;
//		getFlights();
		
		Booking booking = new Booking();
		booking.setFlightId(1);
		
		createBooking(booking);
	}
	
	@Override
	public List<Flight> getFlights() {
		List<Flight> flights = new ArrayList<>();	
		Flight flight1 = new Flight();
		flight1.setId(1);
		flight1.setSource("DEHAM");
		flight1.setTarget("USNYC");
		Flight flight2 = new Flight();
		flight2.setId(2);
		flight2.setSource("DEHAM");
		flight2.setTarget("FRPAR");
		Flight flight3 = new Flight();
		flight3.setId(3);
		flight3.setSource("DEHAM");
		flight3.setTarget("MXMXI");
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		return flights;
		}

	@Override
	public List getHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCars() {
		// TODO Auto-generated method stub
		return null;
	}

	public Booking createBooking(Booking booking) {
		
		universalQueueRequester.placeInQueue("allFlights", createFlightRequest(booking.getFlightId()));
		
		// TODO Auto-generated method stub
		return null;
	}
	
	private FlightRequest createFlightRequest(final int id) {
		FlightRequest flightRequest = new FlightRequest();
		flightRequest.setId(id);
		
		return flightRequest;
	}

}
