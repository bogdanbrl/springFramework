package com.criptex.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.criptex.spring.domain.promotion.TradeFair;

public class ComponentAnnotationApp {

	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		
		TradeFair tradeFair = (TradeFair) ctx.getBean("myfair");
		System.out.println(tradeFair.specialPromotionalPricing() );
		
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}










