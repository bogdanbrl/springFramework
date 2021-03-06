package com.criptex.spring;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.domain.Organization;

@Service
public class DaoUtils {

	private static Logger LOGGER = LoggerFactory.getLogger("Loggong Tester");
	
	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";
	
	public void printOrganizations(List<Organization> orgs, String operation) {
		LOGGER.info("\n**************** printing organization after "+ operation + " operation *******************");
		for (Organization org : orgs) {
			LOGGER.info(org.toString());
		}
	}
	
	public void printOrganization(Organization org, String operation) {
		LOGGER.info("\n*************** Printing organization after invoking " + operation + " **************\n" + org);
	}
	
	public void printSuccessFailure(String operation, boolean param) {
		if(param)
			LOGGER.info("\nOperation " + operation + " successful");
		else
			LOGGER.info("\nOperation " + operation + " failed");
	}
	
	public void createSeedData(OrganizationDao  dao) {
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
		LOGGER.info("Created " + createCount + " organizations");
	}
	
	public void printOrganizationCount(List<Organization> orgs, String operation) {
		LOGGER.info("\n****************** Currently we have "+ orgs.size() + " organizations after "+
				operation + " operation" + " ****************");
	}
}
