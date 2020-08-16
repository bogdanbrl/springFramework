package com.criptex.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.criptex.springdemo.domain.test.OrganizationRegistration;

@Controller
@RequestMapping("/formTagsDemo")
public class FormTagsController {

	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("test/formTagsTestViews/formTagsHome", "orgRegistration", new OrganizationRegistration());
	}
	
	@RequestMapping(value= "/registerOrg", method=RequestMethod.POST)
	public String organizationRegistration(@ModelAttribute OrganizationRegistration orgRegistration, Model model) {
		model.addAttribute("orgreg", orgRegistration);
		return "test/formTagsTestViews/formTagsResult";
	}
	
}









































