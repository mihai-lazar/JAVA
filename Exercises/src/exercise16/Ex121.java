package exercise16;


public class Ex121 {
	
	static Card[] cards = new Card[52];
	
	
	public Ex121() {
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}
	
	public Card get(int index) {
		return cards[index];
	}
	
	public int length() {
		return cards.length;
	}
	
	
	
	public int[] suitHist(Card[] hand){
		int[] cont = {0, 0, 0, 0};
		for(int i = 0 ; i < hand.length ; i++) {
			cont[hand[i].getSuit()] = cont[hand[i].getSuit()] + 1;
		}		
		return cont;
	}
	
	public boolean hasFlush(Card[] hand){
		int[] cont = {0, 0, 0, 0};
		for(int i = 0 ; i < hand.length ; i++) {
			cont[hand[i].getSuit()] = cont[hand[i].getSuit()] + 1;
		}	
		for(int i = 0 ; i < 4 ; i++) {
			if(cont[i] >= 5)
				return true;
		}
		return false;
	}
	
	
	
	
	public static void main(String[] args) 
	{
		Ex121 Deck = new Ex121();		
		
		
		
		System.out.println(Deck.suitHist(cards)[0] + " " + Deck.suitHist(cards)[1] + " " + Deck.suitHist(cards)[2] + " " + Deck.suitHist(cards)[3]);
		
		System.out.println(Deck.hasFlush(cards));
		
		System.out.println(Deck.get(0).compareTo(Deck.get(13)));
		
		System.out.println(Deck.get(0));
		System.out.println(Deck.get(13));
		System.out.println(Deck.get(4).getSuit());
	}



}
