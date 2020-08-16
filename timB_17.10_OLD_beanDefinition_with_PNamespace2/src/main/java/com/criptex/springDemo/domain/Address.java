package com.criptex.springDemo.domain;

public class Address {

	private String street;
	private String city;
	private String zipCode;
	
	// if c namespace is usedwith constructor, p namespace is used with setter. So generate setters.
	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
}
