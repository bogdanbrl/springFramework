package com.bogdan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bogdan.service.demo.GenericWelcomeSevice;
import com.bogdan.service.demo.WelcomeService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeSevice welcomeService;
	
	@RequestMapping("/")
	//http://localhost:8080/spring-mvc-demo-1/
	
	public String doWelcome(Model model) {
		
		//1.retriving the processed data
		//WelcomeService welcomeService = new WelcomeService();
		
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Bogdan");
		
		// 2. add data to the model
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		
		// 3. return logical view name
		return "welcomeNew"; //WebContent/WEB-INF/views/welcomeNew.jsp
	}
}
