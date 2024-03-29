package exercise18;

import java.util.ArrayList;

public class Ex142 extends Player{

	public Ex142(String name) {
		super(name);
	}
	
	private static int eval(int rank, int total, boolean vary){
	      if (rank > 10){
	         return 10;
	      }
	      if (rank == 8){
	         if (total < 5 && !vary){
	            return 12;
	         }
	         return 0;
	      }
	      return rank;
	}
	
	public Card searchForMatch(Card prev) {
	      int[] suitStat = new int[4];
	      int[] rankStat = new int[14];
	      int index = -1;
	      Hand mano = getHand();
	      ArrayList<Integer> posibilidad = new ArrayList<Integer>();
	      for (int i = 0; i < mano.size(); i++) {
	         Card card = mano.getCard(i);
	         int suit = card.getSuit();
	         int rank = card.getRank();
	         suitStat[suit] += 1;
	         rankStat[rank] += 1;
	         if (card.compareTo(prev) == 0){ 
	        	 posibilidad.add(i);
	            if (posibilidad.size() == 1){ index = i; }
	         }
	      }
	      int total = posibilidad.size();
	      if (total == 0){ 
	         return null; 
	      } 
	      if (total > 1){
 
	         int max = -1;
	         boolean vary = true;
	         for (int i=0;i<4;i++){ 
	            if (suitStat[i] == 0){
	               vary = false; 
	               break;
	            } 
	         }
	         for (int i=0;i<total;i++){
	            int position = posibilidad.get(i);
	            Card card = mano.getCard(position);  
	            int rank = card.getRank();
	            int suit = card.getSuit();
	            int val = eval(rank, total, vary);

	            int value = val * 3 + suitStat[suit] * 6 + rankStat[rank] * 5;
	            if (value > max) { index = position; max = value; }
	         }
	      }
	      return mano.popCard(index);
	}

}
