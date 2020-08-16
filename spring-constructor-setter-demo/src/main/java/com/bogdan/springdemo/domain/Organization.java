package com.bogdan.springdemo.domain;

import com.bogdan.springdemo.service.IBusinessService;
import com.bogdan.springdemo.serviceimpl.CloudServiceImpl;
import com.bogdan.springdemo.serviceimpl.EcommerceSeviceImpl;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	
	
	private IBusinessService businessService = new CloudServiceImpl();
	
	//public Organization() {	}	
	
	
	
	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName=companyName;
		this.yearOfIncorporation=yearOfIncorporation;
	}	
	
	
	public String getCompanyName() {
		return companyName;
	}


	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}


	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public void corporateSlogan() {
		String slogan = "We build the ultimate driving machines!";
		System.out.println(slogan);
	}
	
	public String corporateService() {
		return this.businessService.offerService(companyName);
	}

	
	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}


	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan
				+ "]";
	}
	
	
	
	
}
