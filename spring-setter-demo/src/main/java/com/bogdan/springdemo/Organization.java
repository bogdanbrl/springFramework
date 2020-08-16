package com.bogdan.springdemo;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	
	//public Organization() {	}	
	
	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName=companyName;
		this.yearOfIncorporation=yearOfIncorporation;
	}	
	
	
	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public void corporateSlogan() {
		String slogan = "We build the ultimate driving machines!";
		System.out.println(slogan);
	}

	
	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}
	
	
}
