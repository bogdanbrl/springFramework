package com.criptex.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.criptex.spring.interceptors.ExecutionTimerInterceptor;
import com.criptex.spring.interceptors.HeaderInterceptor;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.criptex")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private HeaderInterceptor headerInterceptor;
	@Autowired
	private ExecutionTimerInterceptor executionTImerInterceptor;
	
	@Bean
	public DataSource DataSource() {
		 final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		 dsLookup.setResourceRef(true);
		 DataSource dataSource = dsLookup.getDataSource("jdbc/springdb");
		 return dataSource;
	}
	
	@Bean
	public UrlBasedViewResolver UrlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		
		// echivalent in xml file
		// <mvc:view-controller path = "/" view-name="home"/>
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerInterceptor);
		registry.addInterceptor(executionTImerInterceptor).addPathPatterns("/location");
	}
	
	
}




















