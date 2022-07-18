import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Method main deals hands. */
public class Deal {

	/** Precondition: args[0] is the number of hands --no. of people playing.<br>
	 * ............. args[1] is the number cards to be dealt to each hand.<br>
	 * ............. args[0] * args[1] <= 52.<br>
	 * Starting with a complete deck, deal args[1] cards to each of args[0] hands. */
	public static void main(String args[]) {
		int numHands= Integer.parseInt(args[0]);
		int cardsPerHand= Integer.parseInt(args[1]);

		List<Card> deck= Card.newDeck();
		Collections.shuffle(deck);

		List<Card>[] hands= createHands(numHands);

		deal(deck, hands, cardsPerHand);

		for (int i= 0; i < numHands; i++ ) {
			System.out.println(hands[i]);
		}
	}

	/** Create and return an array of m hands, each holding no cards. */
	public static List<Card>[] createHands(int m) {
		ArrayList<Card>[] hands= createArray(m);
		for (int k= 0; k < hands.length; k= k + 1)
			hands[k]= new ArrayList<>();
		return hands;
	}

	/** Precondition: deck contains enough cards to deal n cards to each element of hands.<br>
	 * Deal them. That is, repeat this n times: <br>
	 * .............. for each element of hands, take a card from deck and place<br>
	 * .............. it in that element of hands */
	public static void deal(List<Card> deck, List<Card>[] hands, int n) {
		for (int i= 0; i < n; i= i + 1) {
			// Move a card from the deck to each element of hands
			for (List<Card> hand : hands) {
				hand.add(deck.remove(deck.size() - 1));
			}
		}
	}

	/** Create and return an array of size n. <br>
	 * This is necessary because generics and arrays don't interoperate nicely. <br>
	 * A student in CS2110 would not be expected to know about the need for <br>
	 * this method and how to write it. <br>
	 * We had to search the web to find out how to do it. */
	@SuppressWarnings("unchecked")
	static ArrayList<Card>[] createArray(int n) {
		return (ArrayList<Card>[]) Array.newInstance(ArrayList.class, n);
	}
}