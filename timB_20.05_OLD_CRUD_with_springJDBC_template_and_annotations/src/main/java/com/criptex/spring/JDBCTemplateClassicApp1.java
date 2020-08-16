package com.criptex.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.daoimpl.OrganizationDaoImpl;
import com.criptex.spring.domain.Organization;

public class JDBCTemplateClassicApp1 {

	public static void main(String[] args) {
		// creating the application contex
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");
		
		// create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		List<Organization> orgs = dao.getAllOrganizations();
		for (Organization org : orgs) {
			System.out.println(org);
		}
		
		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
