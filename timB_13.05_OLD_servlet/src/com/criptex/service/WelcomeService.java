package com.criptex.service;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService {
	
	public List<String> getWelcomeMessage (String name){
		
		List<String> welcomeMessage = new ArrayList<>();
		welcomeMessage.add("Welcome ");
		welcomeMessage.add(name);
		welcomeMessage.add(" , to the Spring course! :-)");
		return welcomeMessage;
	}
}
