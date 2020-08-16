package com.criptex.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.criptex.spring.dao.OrganizationDao;
import com.criptex.spring.daoimpl.OrganizationDaoImpl;
import com.criptex.spring.domain.Organization;

public class JDBCTemplateException {

	public static void main(String[] args) {
		// creating the application contex
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");
		
		// create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		List<Organization> orgs = null;
		try {
			orgs = dao.getAllOrganizations();
		} catch (BadSqlGrammarException bge) {
			System.out.println("SUB EXEPTION MESSAGE: " + bge.getMessage());
			System.out.println("SUB EXEPTION CLASS: " + bge.getClass());
		} catch (DataAccessException dae) {
			System.out.println("EXEPTION MESSAGE: " + dae.getMessage());
			System.out.println("EXEPTION CLASS: " + dae.getClass());
		}
		dao.getAllOrganizations();
		for (Organization org : orgs) {
			System.out.println(org);
		}
		
		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
