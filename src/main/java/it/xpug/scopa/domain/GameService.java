package it.xpug.scopa.domain;

public interface GameService {

	void play(String card);

	String[] table();

	String[] playerHand();

	public abstract int countOfCapturedCards();

	public abstract void startNewGame();


}