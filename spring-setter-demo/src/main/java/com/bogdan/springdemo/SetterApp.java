package com.bogdan.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SetterApp {

	public static void main(String[] args) {
		// create application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//print organization details
		System.out.println(org);
				
		//invoke the company slogan via the bean
		org.corporateSlogan();
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
