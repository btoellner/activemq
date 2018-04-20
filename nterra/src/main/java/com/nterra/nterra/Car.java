package com.nterra.nterra;

public class Car {
	
	private int id;
	private String rentalCompany;
	
	public Car(int id, String rentalCompany) {
		super();
		this.id = id;
		this.rentalCompany = rentalCompany;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRentalCompany() {
		return rentalCompany;
	}
	public void setRentalCompany(String rentalCompany) {
		this.rentalCompany = rentalCompany;
	}
}
