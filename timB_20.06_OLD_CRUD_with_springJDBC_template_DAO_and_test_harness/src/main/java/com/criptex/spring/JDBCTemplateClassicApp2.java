package com.criptex.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.daoimpl.OrganizationDaoImpl;
import com.criptex.spring.domain.Organization;

public class JDBCTemplateClassicApp2 {

	public static void main(String[] args) {
		// creating the application contex
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");
		
		// create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		
		//creating seed data
		DaoUtils.createSeedData(dao);
		
		//List organizations
		List<Organization> orgs = dao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);
		
		// create a new organization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.readOperation);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.readOperation);
		
		//get a single organization
		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");
		
		//updating a slogan for organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build **awesome** driving machines!");
		boolean isUpdated = dao.update(org3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(dao.getOrganization(2), DaoUtils.updateOperation);
		
		// delete an organization 
		Organization org3_1 = dao.getOrganization(5);
		boolean isDeleted = dao.delete(org3_1);
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.deleteOperation);
		// clean up
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.cleanupOperation);
		
		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
