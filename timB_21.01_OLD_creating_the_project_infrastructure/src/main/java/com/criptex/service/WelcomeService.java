package com.criptex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements GenericWelcomeService {
	
	public List<String> getWelcomeMessage (String name){
		
		List<String> welcomeMessage = new ArrayList<>();
		welcomeMessage.add("Welcome ");
		welcomeMessage.add(name);
		welcomeMessage.add(", to the Spring course! :-)");
		return welcomeMessage;
	}
}
