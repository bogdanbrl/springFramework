package com.bogdan.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bogdan.springdemo.domain.Organization;
import com.bogdan.springdemo.domain.promotion.TradeFair;


public class PropertiesWithXMLApp {

	public static void main(String[] args) {
		// create application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		Organization organization = (Organization) ctx.getBean("myorg");
		System.out.println(organization);
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
