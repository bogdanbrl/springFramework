package com.bogdan.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bogdan.springdemo.domain.Organization;


public class BeanScopeApp {

	public static void main(String[] args) {
		// create application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg");
		org2.setPostalCode("98989");
		
		//print organization details
		System.out.println(org);
		System.out.println(org2);
		if(org == org2) {
			System.out.println("Singleton scope test: org and org2 point to the same instance");
		}
		//System.out.println(org.corporateService());
				
		//invoke the company slogan via the bean
		org.corporateSlogan();
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
