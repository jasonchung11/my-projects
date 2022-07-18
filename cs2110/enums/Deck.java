import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** An instance contains a deck of cards, with methods<br>
 * to play around with them. Look at method main. */
public class Deck {

	/** Contains the deck of cards currently being played with. */
	private List<Card> cards; // Deck of cards

	/** Constructor: a deck of 52 playing cards. */
	public Deck() {
		cards= Card.newDeck();
	}

	/** Shuffle the deck. */
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}

	/** Draw one card from the top of the deck. */
	public Card drawCard() {
		return cards.remove(cards.size() - 1);
	}

	/** Store in field cards a deck of cards without suit s. */
	public void removeAll(Suit s) {
		// Task is done by building a new deck buildDeck that
		// contains only cards not of suit s
		ArrayList<Card> buildDeck= new ArrayList<>();
		cards= Card.newDeck();
		for (Card card : cards) {
			// Note: Use != and == to compare enum values. equals works too
			if (card.suit() != s) {
				buildDeck.add(card);
			}
		}
		cards= buildDeck;
	}

	/** Return the probability of a card being red. */
	public double probabilityOfRed() {
		int numRed= 0;
		for (Card c : cards) {
			// Suit has instance methods that can be called on any Suit enum value
			if (c.isRed()) {
				numRed++ ;
			}
		}
		return (double) numRed / cards.size();
	}

	/** Return the probability of a card being black. */
	public double probabilityOfBlack() {
		return 1 - probabilityOfRed();
	}

	/** Return a representation of this Deck. */
	public @Override String toString() {
		return Arrays.toString(cards.toArray());
	}

	public void printProbabilities() {
		System.out.println("Probability of red:   " + probabilityOfRed());
		System.out.println("Probability of black: " + probabilityOfBlack());
		System.out.println();
	}

	/** 0. Show that Suit extends Enum. <br>
	 * 1. Print the values of class Suit.<br>
	 * 2. Create and print a deck of cards. <br>
	 * 3. Print probabilities of a card being red or black in a new deck. <br>
	 * 4. Remove the hearts and again print the probabilities. <br>
	 * 5. Shuffle a new deck, draw and print 7 cards, print probabilities again. */
	public static void main(String[] args) {

		// 1. Print the values of class Suit.
		// This demos method values() and the foreach statement
		for (Object s : Suit.values()) {
			System.out.println(s);
		}

		// 2. Create and print a deck of cards
		Deck d= new Deck();
		System.out.println(d);
		System.out.println();

		// 3. Print probabilities of a card being red or black in a new deck
		System.out.println("New deck of cards");
		d.printProbabilities();

		// 4. Remove the hearts and print the probabilities.
		System.out.println("Removing all hearts");
		d.removeAll(Suit.HEARTS);
		d.printProbabilities();

		// 5. Shuffle a new deck, draw and print 7 cards, print probabilities again.
		System.out.println("New deck of cards. Shuffling and drawing 7 random cards.");
		d= new Deck();
		d.shuffleDeck();
		for (int i= 0; i < 7; i++ ) {
			System.out.println(d.drawCard());
		}
		d.printProbabilities();
	}

}
