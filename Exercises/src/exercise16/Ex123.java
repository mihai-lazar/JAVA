package exercise16;

public class Ex123 {

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
	
}
