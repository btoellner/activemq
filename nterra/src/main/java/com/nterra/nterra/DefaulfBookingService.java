package com.nterra.nterra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaulfBookingService implements BookingService {

	private UniversalQueueRequester universalQueueRequester;
	
	int bookingId; 
	boolean isAvailable;
	FlightStatus flightStatus;
	HotelStatus hotelStatus;
	CarStatus carStatus;
//	private UniversalQueueConsumer universalQueueConsumer;
	
	@Autowired
	public DefaulfBookingService(UniversalQueueRequester universalQueueRequester) {
		this.universalQueueRequester = universalQueueRequester;
		
//		getFlights();
		
		Booking booking = new Booking();
		booking.setFlightId(1);
		booking.setHotelId(1);
		booking.setCarId(1);
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
	public List<Hotel> getHotels() {
		List<Hotel> hotels = new ArrayList<>();	
		Hotel hotel1 = new Hotel(1,"USNYC");
		Hotel hotel2 = new Hotel(2,"FRPAR");
		Hotel hotel3 = new Hotel(3,"MXMXI");
		hotels.add(hotel1);
		hotels.add(hotel2);
		hotels.add(hotel3);
		return hotels;
		
	}

	@Override
	public List<Car> getCars() {
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Car(1, "Sixt"));
		cars.add(new Car(2, "Hertz"));
		cars.add(new Car(3, "Europcar"));
		
		return cars;
	}

	public Booking createBooking(Booking booking) {
		
		universalQueueRequester.placeInQueue("bookFlight", createFlightRequest(booking.getFlightId()));
		universalQueueRequester.placeInQueue("bookHotel", createHotelRequest(booking.getHotelId()));
		universalQueueRequester.placeInQueue("bookCar", createFlightRequest(booking.getCarId()));
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private FlightRequest createFlightRequest(final int id) {
		FlightRequest flightRequest = new FlightRequest();
		flightRequest.setId(id);
		
		return flightRequest;
	}
	
	private HotelRequest createHotelRequest(final int id) {
		HotelRequest hotelRequest = new HotelRequest();
		hotelRequest.setId(id);
		
		return hotelRequest;
	}

	// Flight Company Logik 
	@Override
	public void handleFlightBooking(Integer flightId) {
		boolean isAvailable = false;
		if(flightId >1) {
			isAvailable = true;
		}
		universalQueueRequester.placeInQueue("flightStatus",new FlightStatus(isAvailable, flightId));
	}

	@Override
	public void handleHotelBooking(Integer hotelId) {
		boolean isAvailable = false;
		if(hotelId >1) {
			isAvailable = true;
		}
		universalQueueRequester.placeInQueue("hotelStatus",new HotelStatus(isAvailable, hotelId));
		
	}

	@Override
	public void handleCarBooking(Integer carId) {
		boolean isAvailable = false;
		if(carId >1) {
			isAvailable = true;
		}
		universalQueueRequester.placeInQueue("carStatus",new CarStatus(isAvailable, carId));
	}

	public BookingStatus getBookingStatus() {
		return new BookingStatus(bookingId, isAvailable, flightStatus, hotelStatus, carStatus);
	}

//	public UniversalQueueRequester getUniversalQueueRequester() {
//		return universalQueueRequester;
//	}
//
//	public void setUniversalQueueRequester(UniversalQueueRequester universalQueueRequester) {
//		this.universalQueueRequester = universalQueueRequester;
//	}

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
