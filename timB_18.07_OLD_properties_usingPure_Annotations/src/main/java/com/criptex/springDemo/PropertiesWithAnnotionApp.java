package com.criptex.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.criptex.spring.domain.Organization;
import com.criptex.spring.domain.PropertyConfig;


public class PropertiesWithAnnotionApp {

	public static void main(String[] args) {
	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Organization org = (Organization) ctx.getBean("myorg");
		System.out.println(org);
		System.out.println(org.corporateSlogan());
		((AnnotationConfigApplicationContext) ctx).close();		
	}

}










