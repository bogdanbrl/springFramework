package com.criptex.spring.domain;

import com.criptex.spring.service.BusinessService;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	public Organization() {
		
	}
	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	public String corporateSlogan() {
		return slogan;
	}

	// this is the methode that accesses the businessService and executes the offerService methode
	// after the injection of the desired service implementation
			// this is methode - setter based dependency injection
	public String corporateService() {
		return businessService.offerService(companyName);
	}
	
	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}
}
