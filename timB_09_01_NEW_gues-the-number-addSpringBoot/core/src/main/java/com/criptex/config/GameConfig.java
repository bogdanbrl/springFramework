package com.criptex.config;

import com.criptex.GuessCount;
import com.criptex.MaxNumber;
import com.criptex.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.criptex")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber}")             // we can use a default value if in our properties file isn't mentioned the maxNumber @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.minNumber:5}")             // we can use a default value if in our properties file isn't mentioned the maxNumber @Value("${game.maxNumber:20}")
    private int minNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}
