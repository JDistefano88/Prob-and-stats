// made by Joshua Distefano with help from Joe Delizzo
public class Card implements Comparable<Card> {
	private String suite;
	private int number;
	
	Card(String s, int n) {
		this.suite = s;
		this.number = n;
	}

	/*Below are the getter and setter methods for the numbers and suits.
	These help the handEvaluator class is comparing numbers and suites */
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String toString() {
		return suite + " " +number;
	}
	//This allows two cards to be compared with the number of each card.
	@Override
	public int compareTo(Card o){
		return Integer.compare(number, o.getNumber());
	}
	
}