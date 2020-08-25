package com.criptex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // folosit pentru a crea un controller astfel incat sa nu mai dea http status 404 not found
    // apoi o sa apara http status 500 internal server error daa nu este setat view resolverul sau un controller view
    //in cazul nostru @ResponseBodyva lega metoda direct de bodyul fisierului html/php etc.

    // http://localhost:8080/timB_07_02_NEW_todo_list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    // http://localhost:8080/timB_07_02_NEW_todo_list/welcome
//    @GetMapping("welcome")
//    public String welcome(){
//        return "welcome";
//    }

    @GetMapping("welcome")
    public String welcome(Model model){
        model.addAttribute("user", "Bogdan");
        log.info("model = {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return "Welcome to this Demo application.";
    }
}
