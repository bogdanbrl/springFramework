package com.bogdan.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeSevice{
	public List<String> getWelcomeMessage(String name){
		List<String> myWelcomeMessage = new ArrayList<>();
		
		//add data to list
		myWelcomeMessage.add("Hallo! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", welcome to spring course :-)");
		
		return myWelcomeMessage;
	}
}
