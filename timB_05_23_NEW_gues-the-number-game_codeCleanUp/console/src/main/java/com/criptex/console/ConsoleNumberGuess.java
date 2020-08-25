package com.criptex.console;

import com.criptex.Game;
import com.criptex.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fileds ==
    private final Game game;

    private final MessageGenerator messageGenerator;

    // == constructors ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == event ==
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Container ready to use.");

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgaingString = scanner.nextLine().trim();
                if (!playAgaingString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }

//    // the upper method can be replaced with:
//    @EventListener(ContextRefreshedEvent.class)
//    public void start(){
//        log.info("start() --> Container ready touse.");
//    }
}
