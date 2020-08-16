package com.criptex.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.criptex.spring.domain.Organization;


public class PropertiesUsingXMLApp {

	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		Organization org = (Organization) ctx.getBean("myorg");
		System.out.println(org);
		
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}










