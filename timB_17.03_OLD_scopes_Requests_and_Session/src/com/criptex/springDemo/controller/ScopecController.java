package com.criptex.springDemo.controller;


import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.criptex.springDemo.service.RandomizerRequstScope;
import com.criptex.springDemo.service.RandomizerSessionScope;

@Controller
public class ScopecController {

	@Autowired
	RandomizerRequstScope randomizerRequstScope;
	
	@Autowired
	RandomizerSessionScope randomizerSessionScope;
	
//	we are using @Autowired annotations here so that we can inject an
//	instance of the relevant object, RandomizerRequestScope and 
//	RandomizerSessionScope. Of course, we have declared those as beans in our Spring 
//	configuration file.
	
	@RequestMapping
	public void getRandom(HttpServletResponse response) throws Exception{
		response.getWriter().write("******************* request scope *******************<br>");
		response.getWriter().write("Old number: " + randomizerRequstScope.getRandomNumber() + "<br>");
		randomizerRequstScope.generateRandomNumber();
		response.getWriter().write("New number: " + randomizerRequstScope.getRandomNumber() + "<br>");
		response.getWriter().write("Objecy reference: " + randomizerRequstScope + "<br>");
		
		
		response.getWriter().write("******************* session scope *******************<br>");
		response.getWriter().write("Old number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Objecy reference: " + randomizerSessionScope + "<br>");
	}
}
