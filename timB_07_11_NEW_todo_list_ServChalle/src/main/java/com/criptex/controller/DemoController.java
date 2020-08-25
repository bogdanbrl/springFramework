package com.criptex.controller;

import com.criptex.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    // == request methods ==


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
    // http://localhost:8080/timB_07_02_NEW_todo_list/welcome?user=Bogdan&age=23
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model = {}", model);
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
