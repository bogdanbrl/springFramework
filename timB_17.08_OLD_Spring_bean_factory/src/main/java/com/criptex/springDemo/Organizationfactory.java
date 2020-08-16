package com.criptex.springDemo;

public class Organizationfactory {
	
	public Organization getInstance(String companyName, int yearOfIncorporation) {
		System.out.println("Invoking instance factory method.................");
		return new Organization(companyName, yearOfIncorporation);
	}
}
