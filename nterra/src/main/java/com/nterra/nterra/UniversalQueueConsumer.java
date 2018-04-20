package com.nterra.nterra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class UniversalQueueConsumer {	
	
	@Autowired
	public Gson gson;
	
	@Autowired
	public JmsTemplate jmsTemplate;
	
	@Autowired
	public DefaulfBookingService bookingService;
	
	@SuppressWarnings("unchecked")
	public Object pickFromQueue(final String queueName, final Class classType) {
		
		String message = (String) jmsTemplate.receiveAndConvert(queueName);
		
		return gson.fromJson(message, classType);
	}
	
	
	@JmsListener(destination="bookFlight")
	public void pickUpFromBookFlightQueue(String message) {
		
		FlightRequest flightRequest = gson.fromJson(message, FlightRequest.class);
		
		Integer flightId = flightRequest.getId();
		
		bookingService.handleFlightBooking(flightId);
	}
	
	@JmsListener(destination="bookHotel")
	public void pickUpFromBookHotelQueue(String message) {
		HotelRequest hotelRequest = gson.fromJson(message, HotelRequest.class);
		
		Integer hotelId = hotelRequest.getId();
		
		bookingService.handleHotelBooking(hotelId);
		
	}
	
	@JmsListener(destination="bookCar")
	public void pickUpFromBookCarQueue(String message) {

		CarRequest carRequest = gson.fromJson(message, CarRequest.class);
		
		Integer carId = carRequest.getId();
		
		bookingService.handleCarBooking(carId);
	}
	
	@JmsListener(destination="flightStatus")
	public void pickUpFromBookFlightStatus(String message) {
		FlightStatus flightStatus = gson.fromJson(message, FlightStatus.class);
		bookingService.setFlightStatus(flightStatus);
	}
	
	@JmsListener(destination="hotelStatus")
	public void pickUpFromBookHotelStatus(String message) {
		HotelStatus hotelStatus = gson.fromJson(message, HotelStatus.class);
		bookingService.setHotelStatus(hotelStatus);

	}
	
	@JmsListener(destination="carStatus")
	public void pickUpFromBookCarStatus(String message) {
		CarStatus carStatus = gson.fromJson(message, CarStatus.class);
		bookingService.setCarStatus(carStatus);
	}
}