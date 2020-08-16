package com.bogdan.springdemo.domain;

import com.bogdan.springdemo.service.BusinessService;
import com.bogdan.springdemo.serviceimpl.CloudServiceImpl;
import com.bogdan.springdemo.serviceimpl.EcommerceSeviceImpl;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	
	
	private BusinessService businessService = new CloudServiceImpl();
	
	public Organization() {
		System.out.println("Default constructor called!");
	}	
	
	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName=companyName;
		this.yearOfIncorporation=yearOfIncorporation;
		System.out.println("Constructor called!");
	}	
	
	public void initialize() {
		System.out.println("organization: initialize method called");
	}
	
	public void destroy() {
		System.out.println("organization: destroy method called");
	}
	
	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called!");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmployeeCount called!");
	}


	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called!");
	}

	public void corporateSlogan() {
		String slogan = "We build the ultimate driving machines!";
		System.out.println(slogan);
	}
	
	public String corporateService() {
		return this.businessService.offerService(companyName);
	}

	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called!");
	}


	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan
				+ "]";
	}
	
	
	
	
}
