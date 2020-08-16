package com.criptex.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.criptex.spring.domain.HumanResourceDeptarment;
import com.criptex.spring.domain.Organization;

public class DependencyInjection_constructor {

	public static void main(String[] args) {
		// create the application context (container)
		// notice that using classPath bean files is moved into resources folder, after creating it
		// right click on project, new source folder, then browse to main folder, create resource folder, finish
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		// invoke the company slogan via the bean
		System.out.println(org.corporateSlogan());
		
		//invoke the corporateService methode - dependency injection??
		System.out.println(org.corporateService());
		
		//print organization details
		System.out.println(org);
		
		HumanResourceDeptarment hrDept = (HumanResourceDeptarment) ctx.getBean("myhrdept");
		System.out.println(hrDept.hiringStatus(5500));
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}










