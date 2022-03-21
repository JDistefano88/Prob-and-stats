// made by Joshua Distefano with help from Joe Delizzo
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	/*The setCards method will take the cards that are generated below and
	implement them into an array. This allows a deck arrray to be created with
	the array of cards. */

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	Deck() {
		cards = new ArrayList<>();
		ArrayListbuildDeck();
	}
	
	public Card drawCard() {
		Random gen = new Random();
		Card drawn = cards.remove(gen.nextInt(cards.size()));
		return drawn;
	}
	
	/*This will build all 52 cards that are in a deck. It assigns a number value
	up to 13 for each suite. The numbers 1, 11, 12, 13 represent ace, jack, queen,
	and king respectively.  */

	private void ArrayListbuildDeck() {
		String[] suites = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"};
		for(int j = 0; j < suites.length; j++) {
		for(int i = 1; i <= 13; i++) {
			cards.add(new Card(suites[j], i));
		}
		}
	}
}