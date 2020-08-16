package com.criptex.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.criptex.spring.domain.Organization;

public class BeanScopeApp {

	public static void main(String[] args) {
		// create the application context (container)
		// notice that using classPath bean files is moved into resources folder, after creating it
		// right click on project, new source folder, then browse to main folder, create resource folder, finish
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg");
		org2.setPostalCode("1234567");
		
		// invoke the company slogan via the bean
		System.out.println(org.corporateSlogan());
		System.out.println(org2.corporateSlogan());
		
		//invoke the corporateService methode - dependency injection??
		System.out.println(org.corporateService());
		System.out.println(org2.corporateService());
		
		//print organization details
		System.out.println(org);
		System.out.println(org2);
		if(org == org2) {
			//if you modify scope in beans-cp.xml file to singleton
			//this is not an error. I just evidentiate the scope element
			System.err.println("Singleton scope test: org and org2 point to the same instance.");
		}else {
			//if you modify scope in beans-cp.xml file to prototype
			System.err.println("Prototype scope test: org and org2 DOESN'T point to the same instance.");
		}
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}










