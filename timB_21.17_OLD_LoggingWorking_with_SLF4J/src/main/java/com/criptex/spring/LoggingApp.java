package com.criptex.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.domain.Organization;

@Component
public class LoggingApp {

	@Autowired
	private OrganizationDao dao;
	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {
		// creating seed data
		daoUtils.createSeedData(dao);

		// List organizations
		List<Organization> orgs = dao.getAllOrganizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);

		// create a new organization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.readOperation);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		// get a single organization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, "getOrganization");

		// updating a slogan for organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build **awesome** driving machines!");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);

		// delete an organization
		Organization org3_1 = dao.getOrganization(5);
		boolean isDeleted = dao.delete(org3_1);
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);
		// clean up
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);
	}

	public static void main(String[] args) {
		// creating the application contex
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");
		LoggingApp mainApp = ctx.getBean(LoggingApp.class);
		mainApp.actionMethod();

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
