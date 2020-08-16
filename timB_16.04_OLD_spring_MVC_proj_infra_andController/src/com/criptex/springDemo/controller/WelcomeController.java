package com.criptex.springDemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.criptex.service.GenericWelcomeService;

// add adnotation @Controller and this class (WelcomeController) will act as a controller
// so the server will take commands from here
@Controller
public class WelcomeController {

	@Autowired
	private GenericWelcomeService welcomeService;

//	the MODEL argument to this method, it's basically a container that holds the data, 
//	very similar to what a Java class does. 
//	I've added this @RequestMapping annotation here, 
//	that's used to map web requests onto specific handler classes and, or handler methods.
//	We defined the doWelcome method as the handler method, 
//	and notice that I added the slash in parenthesis,
//	and that configures it so that all request to our app 
//	that match the URL pattern slash will be routed to this method.
	@RequestMapping("/")
	public String doWelcome(Model model) {

		// 1. retrieving the processed data
		// after we had autowired GenericWelcomeService, we no longer need to create a
		// new instance (add it do bean.xml file)
		// WelcomeService welcomeService = new WelcomeService();
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Bogdan");

		// 2. Add data to the model
		model.addAttribute("myWelcomeMessage", welcomeMessage);

		// 3. Return the logical view name
//		String welcomeNew is the logical name of the view to which the request will be forwarded by the controller.
//		In this context, the view is the jsp.
//		So here the requests are going to be forwarded to the welcomeNew.jsp file 
		return "welcomeModified_afterCreatingNewServlet"; // we need to build this path:
															// "/WEB-INF/views/welcomeModified_afterCreatingNewServlet.jsp"
	} // do this in "springMvcDemo-servlet.xml" (bean tab, new bean,
		// InternalResourceViewResolver)
} // welcomeModified_afterCreatingNewServlet is the name of our jsp file
