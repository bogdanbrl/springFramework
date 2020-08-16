package com.criptex.spring.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.criptex")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public DataSource DataSource() {
		 final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//		 dsLookup.setResourceRef(false);
//		 DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdcb/springdb");
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
}
























