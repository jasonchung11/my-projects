import java.util.ArrayList;
import java.util.List;

/** An instance represents one of 52 playing cards. */
public class Card {

	/** The rank, or value, of a card. */
	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	/** The rank of this card. For demo purposes, made public. */
	public final Rank rank;

	/** The suit of this card. For demo purposes, made public. */
	private final Suit suit;

	/** Constructor: a card with rank r and suit s. */
	private Card(Rank r, Suit s) {
		rank= r;
		suit= s;
	}

	/** = the rank of this card. */
	public Rank rank() {
		return rank;
	}

	/** = the suit of this card. */
	public Suit suit() {
		return suit;
	}

	/** = "this card is red." */
	public boolean isRed() {
		return suit.isRed();
		// suit == Suit.HEARTS || suit == Suit.DIAMONDS;
	}

	/** = "this card is black." */
	public boolean isBlack() {
		return suit.isBlack();
		// suit == Suit.SPADES || suit == Suit.CLUBS;
	}

	@Override
	/** = a representation of this card. */
	public String toString() {
		return rank + " of " + suit;
	}

	/** A deck of cards as an array list.<br>
	 * Created before everything else is done --it is static */
	private static final List<Card> protoDeck= new ArrayList<>();

	/** Initialize a prototype Deck of cards, before anything else is done. */
	static {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				protoDeck.add(new Card(rank, suit));
	}

	/** Return a new deck of cards. */
	public static ArrayList<Card> newDeck() {
		return new ArrayList<>(protoDeck); // Return copy of prototype deck
	}

}
