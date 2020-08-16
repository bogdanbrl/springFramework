package com.bogdan.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bogdan.springdemo.domain.HumanResouceDept;
import com.bogdan.springdemo.domain.Organization;


public class DIConstructorApp {

	public static void main(String[] args) {
		// create application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//print organization details
			//System.out.println(org);
			//System.out.println(org.corporateService());
		HumanResouceDept hrdept = (HumanResouceDept) ctx.getBean("myhrdept");
		System.out.println(hrdept.hiringStatus(5500));
		
		
		//invoke the company slogan via the bean
		org.corporateSlogan();
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
