package com.criptex.spring;

import java.util.ArrayList;
import java.util.List;
import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.domain.Organization;

public class DaoUtils {

	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";
	
	public static void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n**************** printing organization after "+ operation + " operation *******************");
		for (Organization org : orgs) {
			System.out.println(org);
		}
	}
	
	public static void printOrganization(Organization org, String operation) {
		System.out.println("\n*************** Printing organization after invoking " + operation + " **************\n" + org);
	}
	
	public static void printSuccessFailure(String operation, boolean param) {
		if(param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}
	
	public static void createSeedData(OrganizationDao  dao) {
		Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Bogdan! Come and take our money!");
		Organization org2 = new Organization("Volvo", 1927, "86868", 90856, "Drive safe!");
		Organization org3 = new Organization("Google", 1994, "57575", 23025, "Don't be evil!");
		Organization org4 = new Organization("Bogdan Inc.", 2022, "22888", 88888, "We care about your money!");
		
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0, org1); orgs.add(1, org2); orgs.add(2, org3); orgs.add(3, org4);
		// int orgCount = orgs.size();
		int createCount = 0;
		for (Organization organization : orgs) {
			boolean isCreated = dao.create(organization);
			if(isCreated)
				createCount += 1;
		}
		System.out.println("Created " + createCount + " organizations");
	}
	
	public static void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n****************** Currently we have "+ orgs.size() + " organizations after "+
				operation + " operation" + " ****************");
	}
}
