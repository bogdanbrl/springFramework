package com.timbuchalka.service.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tim on 9/05/2017.
 */
public class WelcomeService {

    public List<String> getWelcome(String name) {
        List<String> myWelcomeMessage = new ArrayList<>();

        // Add data to the list
        myWelcomeMessage.add("Hello");
        myWelcomeMessage.add(name);
        myWelcomeMessage.add(", welcome to the Spring course.");

        return myWelcomeMessage;
    }
}
