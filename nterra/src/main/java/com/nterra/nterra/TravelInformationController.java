package com.nterra.nterra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelInformationController {
	
	@Autowired
	DefaulfBookingService defaulfBookingService;
	
	@RequestMapping("/flights")
	public List<Flight> getFlights() {
		return defaulfBookingService.getFlights();
	}
	
	@RequestMapping("/hotels")
	public List<Hotel> getHotels() {
		return defaulfBookingService.getHotels();
	}
	
	@RequestMapping("/cars")
	public List<Car> getCars() {
		return defaulfBookingService.getCars();
	}

	
	@RequestMapping(value="/booking", method = RequestMethod.POST)
	public Booking postFlights(@RequestBody Booking booking) {
		return defaulfBookingService.createBooking(booking);
	}
	
	@RequestMapping(value="/bookingStatus")
	public BookingStatus postFlights() {
		return defaulfBookingService.getBookingStatus();
	}
	
}
