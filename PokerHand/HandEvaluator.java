// made by Joshua Distefano with help from Joe Delizzo
import java.text.DecimalFormat;
import java.util.ArrayList;

public class HandEvaluator {
	private Deck deck;
	private ArrayList<Card> hand;
	double goodPair, good2Pair, goodThree, goodFour, 
	goodHouse, goodFlush, goodStraight;
	
	HandEvaluator() {
		deck = new Deck();
		hand = new ArrayList<Card>();
		hand = drawFiveCards();
		/*hand.add(new Card("Spades", 7));
		hand.add(new Card("Spades", 7));
		hand.add(new Card("Spades",3));		//This was used to test the different checks. 
		hand.add(new Card("Spades", 3));	//These numbers and suits were changed throughout the tests.
		hand.add(new Card("Spades",5)); */
	}
	/*This sortHand method is to make sure the code is ordered from greatest
	numerical value to the least numerical value. It does not take the 
	suit into account when ordering cards*/ 

	public void sortHand(){
		hand.sort(null);
	}

	public String showHand() {
		return hand.toString();
	}
	
	/*The checkPair method will check each number that each card has and will
	compare it to the other numerical values that each card has. It combs
	through each card from start to finish. If no cards come back as matching,
	it shows as false. */

	public boolean checkPair() {
		
		for(int i = 0; i < hand.size(); i++) {
			int pointer = i+1;
			for(;pointer < hand.size(); pointer++) {
				if(hand.get(i).getNumber() == hand.get(pointer).getNumber())
					return true;
			}	
		}
		return false;
	}

	/*The removePair method will as it sates remove a pair from the deck. This is used
	in later methods to get multiple pairs, a full house, or any winning hand that
	involves multiple pairs or pairs bigger than two. If this code detects that one
	card has the same numberic value as another, it exctracts the pair into another
	array. This array is used to compare and find the winng situations stated before. */

	public ArrayList<Card> removePair(){
		ArrayList<Card> pair = new ArrayList<>();
		boolean isPair = false;
		for(int i = 0; i < hand.size(); i++) {
			int pointer = i+1;
			for(;pointer < hand.size(); pointer++) {
				if(hand.get(i).getNumber() == hand.get(pointer).getNumber()){
				pair.add(hand.remove(i));
				pair.add(hand.remove(pointer -1));
				isPair = true;
				break;
				}
			}
			if(isPair)
				break;
		}
		return pair;
	}

	/*The CheckThree method uses the remove pair method from earlier and compairs 
	that pair that it extracted to the remaining cards. If any of the remaining cards
	have a matching numerical value to the ones of the extracted pair, it results
	in true. */

	public boolean checkThree() {
			ArrayList<Card> pair = removePair();
			if(pair.size() == 0){
				return false;
			}
			int num = pair.get(0).getNumber();
			for(Card c :hand){
				if(c.getNumber()==num){
					return true;
				}
			}
			return false;
		}

	/*The checkFullHouse method will pull out the first pair that it can find.
	If it can not do this, the method will return false. If it does find a pair,
	it will run the CheckThree method. It then follows those parrameters set in
	the checkThree method to return true or false. */

	public boolean checkFullHouse(){
		ArrayList<Card> pair = removePair();
		if(pair.size() == 0){
			return false;
		}
		return checkThree();
	}
		
	/* The checkFour method will attempt to extract two seperate pairs. If the two
	pairs share the same numerical value for their cards, then the method returns
	true. If not it returns false. It accomplishes this by getting the value of
	the first card in each pair. It's only when they match it becomes true.*/

	public boolean checkFour(){
		ArrayList<Card> pair = removePair();
		ArrayList<Card> pair2 = removePair();
		if(pair2.size() == 0) {
			return false;
		}
		int num = pair.get(0).getNumber();
		int num2 = pair2.get(0).getNumber();
	
		
		if(num == num2){
			return true;
		}
		return false;
	}

				
	/*The checkTwoPair method will atempt to extract one pair and evaluate the
	remaining cards. If another pair comes back from the remaining cards, then
	the method results in true. If the 5 cards has no pairs, the method returns
	false. */

	public boolean checkTwoPair(){
		boolean hasTwoPair = false;
		ArrayList<Card> pair = removePair();
		if(pair.size() == 0){
			hasTwoPair = false;
		}
		else if(checkPair()){
			hasTwoPair = true;
		}
		return hasTwoPair;
	}

	/*The checkFlush method will look through the 5 cards picked for the hand
	and will check the suites of each. If at anypoint the method detects that 
	one card is not the same suite, it returns false. if every card has the
	same suit, it returns true. */

	public boolean checkFlush(){
		int prev = 0;
		for(int i =1; i < hand.size(); i++){
			if(hand.get(i).getSuite() != hand.get(prev).getSuite()){
				return false;
			}
			prev++;
		}
		return true;
	}

	/*The checkStraight method works almost identical to the checkFlush method.
	The only diference is it checks for the numerical value of each card and 
	not the suit of each card. Same rules as the checkFlush method apply
	with the true and false values for checkStraight. */

	public boolean checkStraight(){
		sortHand();
		int prev = 0;
		for(int i = 1; i < hand.size(); i++){
			if(hand.get(i).getNumber() != hand.get(prev).getNumber()+1){
				return false;
			}
			prev++;
		}
		return true;
	} 

	/*the drawFiveCards method is used to make an array of 5 cards from 
	the deck that was generated by the Deck class. these cards are selected
	at random everytime this method is called. */
	private ArrayList<Card> drawFiveCards() {
		ArrayList<Card> cards = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			cards.add(deck.drawCard());
		}
		return cards;
	}

	/* Below are all of the checks to see if any method came back as true.
	The amount of trials are dictated in the tester class and 10,000 tests 
	are used here. After each test, the deck is reshuffled and a new hand
	is chosen. If any method returned as true, a counter keeps track
	of each true instance. Once all trials are complete, the counters are 
	compared to the amount of trials to get a percentage of winning hands for
	each type of win. */

	public void trials(int trialNum){
		for(int i = 0; i < trialNum; i++){;

			if(checkPair() == true){
				goodPair++;
			}
			deck = new Deck();
			hand = drawFiveCards();

			if(checkThree() == true){
				goodThree++;
			}
			deck = new Deck();
			hand = drawFiveCards();

			if(checkFullHouse() == true){
				goodHouse++;
			}
			deck = new Deck();
			hand = drawFiveCards();

			if(checkFour() == true){
				goodFour++;
			}
			deck = new Deck();
			hand = drawFiveCards();

			if(checkTwoPair() == true){
				good2Pair++;
			}
			deck = new Deck();
			hand = drawFiveCards();

			if(checkFlush() == true){
				goodFlush++;
			}
			deck = new Deck();
			hand = drawFiveCards();

			if(checkStraight() == true){
				goodStraight++;
			}
			deck = new Deck();
			hand = drawFiveCards();
		}
		printResults(trialNum, goodPair, good2Pair, goodThree,
		 goodFour, goodHouse, goodFlush, goodStraight);
	}

	private void printResults( int trialNum, double goodPair,  double good2Pair, double goodThree, 
	double goodFour, double goodHouse, double goodFlush, double goodStraight){
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(4);
		System.out.println("Out of " + trialNum + " trials:");
		System.out.println("Percentage of a One Pair: " + (df.format(goodPair/trialNum * 100)) + "%" );
		System.out.println("Percentage of a Three of a Kind: " + (df.format(goodThree/trialNum * 100)) + "%" );
		System.out.println("Percentage of a Full House: " + (df.format(goodHouse/trialNum * 100)) + "%" );
		System.out.println("Percentage of a Four of a Kind: " + (df.format(goodFour/trialNum * 100)) +"%");
		System.out.println("Percentage of a Two Pair: " + (df.format(good2Pair/ trialNum * 100)) + "%");
		System.out.println("Percentage of a Flush: " + (df.format(goodFlush/trialNum * 100)) +"%");
		System.out.println("Percentage of a Straight: " + (df.format(goodStraight/trialNum * 100)) + "%");
	}
}