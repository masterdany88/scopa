package it.xpug.scopa.acceptance;

import static org.junit.Assert.*;
import it.xpug.scopa.domain.*;

import org.junit.*;

public class CardCaptureScenarioTest {

	private static final Card THREE_OF_CLUBS = new Card(3, Suit.CLUBS);
	private static final Card TWO_OF_CLUBS = new Card(2, Suit.CLUBS);
	private static final Card FIVE_OF_CLUBS = new Card(5, Suit.CLUBS);
	private static final Card FIVE_OF_CUPS = new Card(5, Suit.CUPS);

	CardSet playerPile = new CardSet();
	CardSet playerHand = new CardSet();
	CardSet table = new CardSet();
	
	Game game = new Game(playerHand, playerPile, table);
	
	@Test
	public void playingANonMatchingCard() throws Exception {
		 givenCardsInMyHand(THREE_OF_CLUBS);
		 givenCardsOnTheTable(TWO_OF_CLUBS);
		 whenIPlay(THREE_OF_CLUBS);
		 thenMyHandContains();
		 thenMyPileContains();
		 thenTheTableContains(THREE_OF_CLUBS, TWO_OF_CLUBS);
	}

	@Test
	public void capturingAMatchingCard() throws Exception {
		 givenCardsInMyHand(FIVE_OF_CLUBS);
		 givenCardsOnTheTable(FIVE_OF_CUPS);
		 whenIPlay(FIVE_OF_CLUBS);
		 thenMyHandContains();
		 thenMyPileContains(FIVE_OF_CLUBS, FIVE_OF_CUPS);
		 thenTheTableContains();
	}
	
	private void thenTheTableContains(Card ... cards) {
		assertEquals("table", new CardSet(cards), table);
	}

	private void thenMyPileContains(Card ... cards) {
		assertEquals("my pile", new CardSet(cards), playerPile);
	}

	private void thenMyHandContains(Card ...cards) {
		assertEquals("my hand", new CardSet(cards), playerHand);
	}

	private void whenIPlay(Card card) {
		game.play(card);
	}

	private void givenCardsOnTheTable(Card card) {
		table.add(card);
	}

	private void givenCardsInMyHand(Card card) {
		playerHand.add(card);
	}

}
