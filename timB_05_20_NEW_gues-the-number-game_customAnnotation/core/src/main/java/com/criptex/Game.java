package com.criptex;

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getGuessCount();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidnumberRange();

    boolean isGameWon();

    boolean isGameLost();
}
