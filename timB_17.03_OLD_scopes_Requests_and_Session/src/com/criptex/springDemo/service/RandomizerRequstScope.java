package com.criptex.springDemo.service;

public class RandomizerRequstScope {

	private int randomNumber = 5;
	
	public int getRandomNumber() {
		return randomNumber;
	}
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}
}
