package com.criptex.console;

import com.criptex.config.AppConfig;
import com.criptex.MessageGenerator;
import com.criptex.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // call method next90 to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

//        // get game bean from context (container)
//        Game game = context.getBean(Game.class);

        // get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // call reset method -> instead calling manually, we can configurre the containe rto call reset method
        // game.reset();  -> manually approach -> check beans.xml file

        // close context (container)
        context.close();
    }
}
