package com.criptex.springDemo.domain;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private Address address;

	// if c namespace is usedwith constructor, p namespace is used with setter. So generate setters.
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", address=" + address + "]";
	}

}
