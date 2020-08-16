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
		System.out.println("organization: Default constructor called");
	}
	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("organization: Constructor with parameters called");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("organization: setEmplayeeCount method called");
	}
	
	
	
	
//		The initialize method can be used to do additional processing after all properties are set,
//	either using the constructor or a setter-based dependency injection. So some sort of initialization 
//	that you really want to occur after those properties have been set.
//		The destroy method could be used to do some cleaning up and an example of that  
//	might be you are releasing memory consuming resources such as database connection pools.
	
//	public void initialize() {
//		System.out.println("organization: initialize method called");
//	}
//	
//	public void destroy() {
//		System.out.println("organization: destroy method called");
//	}
	
//	initialize and destroy methods - we are defining the life cycle callback methods 
//	for the organization class, and one thing to keep in mind with these callbacks
//	is they should have a void return type, and also have no arguments in the signature.
//	Names of these callbacks can be anything, but it is recommended to name them in a manner 
//	that it really describes the functionality that they will perform. 
//	Add them in beans-cp.xml file
	
	
	// postConstruct and pre Destroy methods are the default naming of initialize and destroy methods.
	public void postConstruct() {
		System.out.println("organization: postConstruct method called...................");
	}
	
	public void preDestroy() {
		System.out.println("organization: preDestroy method called...................");
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("organization: setPostalCode method called");
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("organization: setSlogan method called");
	}
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("organization: setBusinessService method called");
	}
	
	public String corporateSlogan() {
		return slogan;
	}

	// this is the method that accesses the businessService and executes the offerService method
	// after the injection of the desired service implementation
			// this is method - setter based dependency injection
	public String corporateService() {
		return businessService.offerService(companyName);
	}
	
	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}
}
