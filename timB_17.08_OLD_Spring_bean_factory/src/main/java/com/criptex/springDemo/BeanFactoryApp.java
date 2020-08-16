package com.criptex.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryApp {

	public static void main(String[] args) {
		// create the application context (container)
		// notice that using classPath bean files is moved into resources folder, after creating it
		// right click on project, new source folder, then browse to main folder, create resource folder, finish
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg2");
		
		// invoke the company slogan via the bean
//		org.corporateSlogan();
		
		//print organization details
		System.out.println(org);
		System.out.println(org2);
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}










