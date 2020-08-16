package com.criptex.spring.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.criptex.spring")
@PropertySource(value = {"classpath:properties/organization.properties"})
public class PropertyConfig {
	
	// this class replace beans-cp.xml file, using @Configuration annotation. 
	// delete beans-cp.xml file from resources folder
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}
