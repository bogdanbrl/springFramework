package com.criptex.springDemo;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	
	public Organization() {
		
	}
	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public void corporateSlogan() {
		String slogan = "We build the ultimate driving machines!";
		System.out.println(slogan);
	}

	// Spring Bean instantiation with a static factory method
	// and add it to beans-cp.xml file at factory:method
	public static Organization createInstance(String companyName, int yearOfIncorporation) {
		System.out.println("Invoking the static factory method................");
		return new Organization(companyName, yearOfIncorporation);
	}
	
	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}
}
