package com.bogdan.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bogdan.springdemo.domain.Organization;
import com.bogdan.springdemo.domain.promotion.TradeFair;


public class AutowiredAnotationApp {

	public static void main(String[] args) {
		// create application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		TradeFair tradeFair = (TradeFair) ctx.getBean("myfair");
		System.out.println(tradeFair.specialPromotionalPricing());
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
