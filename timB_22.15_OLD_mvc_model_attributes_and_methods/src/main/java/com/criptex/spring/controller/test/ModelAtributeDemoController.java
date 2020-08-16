package com.criptex.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.criptex.spring.domain.Address;

@Controller
public class ModelAtributeDemoController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAtributeDemoController.class);
	
	@RequestMapping(value="/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	
	//version 2 of our home() method
	@RequestMapping(value ="/home2")
	public ModelAndView home2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeHome");
		mav.addObject("command", new Address());
		return mav;
	}
	
	// version 3 of our home() method
	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView mav = new ModelAndView("modelAttributeHome");
		mav.addObject("anAddress", new Address());
		return mav;
	}
	
	// version 4 of our home() method
	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Lyon", "3000"));
	}
	
	// version 5 of our home() method
	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Hasselt 2", "4000"));
		return "modelAttributeHome";
	}
	
	/*
	*Test series to determine the nature of the @ModelAttribute annottion (on a method)
	*/
	
	// test 1: demonstrating the usage of @ModelAttribute annotation (on a method)
	// to add multiple attributes
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed!");
		model.addAttribute("testdata1B", "We will test both usages of the @ModelAttribute, on methods and on method arguments.");
	}
	
	// testing 2: demonstrating the usage of the 'name' attribute of the @ModelAttribute anntation (on method)
	@ModelAttribute(name="testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		return "We will conduct a seris of test here.";
	}
	
	// Test 3: Demonstrating the usage of the @ModelAttribute annotation (on a method) to implicitly add an attribute 
	// by returning it and also demonstrating the usage og the 'value' attribute of the @ModelAttriute annotation (on a 
	// method)
	@ModelAttribute(value="testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		return new Address("Hamont", "5000");
	}
	
	// Test 4: demonstratethe default naming strategy of the @ModelAttribute annotation (on a method)
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("INSIDE modelAttributeTest4");
		return new Address("Haselt", "2000");
	}
	
	// Test 5: Testing the @ModelAttribute with 'value' attribute and default binding
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		return "modelAttributeTest";
	}
	
	// Test 6: Test to determine the nature of how the @ModelAttribute(on method) and @RequestMapping
	// work with no explicit logical view name
	@RequestMapping(value = "/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeModelTest6() {
		return new Address("Canberra", "2600");
	}
}
