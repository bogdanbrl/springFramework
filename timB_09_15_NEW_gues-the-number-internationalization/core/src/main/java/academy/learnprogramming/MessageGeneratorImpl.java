package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constatans ==
    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String WIN = "game.win";
    public static final String LOOSE = "game.loose";
    public static final String INVALID_RANGE = "game.invalid.range";
    public static final String FIRST_GUESS = "game.first.guess";
    public static final String HIGHER = "game.higher";
    public static final String LOWER = "game.lower";
    public static final String REMAINING = "game.remaining";

    // == fields ==
    private final Game game;
    private final MessageSource messageSource;  // folosit pentru a crea pagina multilingual

    // == constructor ==
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }
    // == public methods ==
    @Override
    public String getMainMessage() {
//        return "Number is between " +
//                game.getSmallest() +
//                " and " +
//                game.getBiggest() +
//                ". Can you guess it?";
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
    }

    @Override
    public String getResultMessage() {

//        if(game.isGameWon()) {
//            return "You guessed it! The number was " + game.getNumber();
//        } else if(game.isGameLost()) {
//            return "You lost. The number was " + game.getNumber();
//        } else if(!game.isValidNumberRange()) {
//            return "Invalid number range!";
//        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
//            return "What is your first guess?";
//        } else {
//            String direction = "Lower";
//
//            if(game.getGuess() < game.getNumber()) {
//                direction = "Higher";
//            }
//
//            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
//        }

        if(game.isGameWon()) {
            return getMessage(WIN, game.getNumber());
        } else if(game.isGameLost()) {
            return getMessage(LOOSE, game.getNumber());
        } else if(!game.isValidNumberRange()) {
            return getMessage(INVALID_RANGE);
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS);
        } else {
            String direction = getMessage(LOWER);

            if(game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER);
            }

            return getMessage(REMAINING, direction, game.getRemainingGuesses());
        }

    }

    // private method that will give us the
    // message from message source, so that way we don't have to repeat the same code
    // everywhere.
    private  String getMessage(String code, Object... args){
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
