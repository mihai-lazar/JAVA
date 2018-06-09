package exercise17;

	import java.util.Arrays;
	import java.util.Random;

	/**
	 * A deck of playing cards (of fixed size).
	 */
	public class Ex132 {

	    private Card[] cards;
	    Random random = new Random();

	    /**
	     * Constructs a standard deck of 52 cards.
	     */
	    public Ex132() {
	        this.cards = new Card[52];
	        int index = 0;
	        for (int suit = 0; suit <= 3; suit++) {
	            for (int rank = 1; rank <= 13; rank++) {
	                this.cards[index] = new Card(rank, suit);
	                index++;
	            }
	        }
	    }

	    /**
	     * Constructs a deck of n cards (null).
	     */
	    public Ex132(int n) {
	        this.cards = new Card[n];
	    }

	    /**
	     * Gets the internal cards array.
	     */
	    public Card[] getCards() {
	        return this.cards;
	    }

	    /**
	     * Displays each of the cards in the deck.
	     */
	    public void print() {
	        for (int i = 0; i < this.cards.length; i++) {
	            System.out.println(this.cards[i]);
	        }
	    }

	    /**
	     * Returns a string representation of the deck.
	     */
	    public String toString() {
	        return Arrays.toString(this.cards);
	    }
	    
	    public String toString(int e) {
	    	for(int i = 0 ; i < this.cards.length - 1 ; i++)
	    		System.out.println(this.cards[i]);
			return "";
	    }

	    /**
	     * Chooses a random number between low and high, including both.
	     */
	    public int randomInt(int low, int high) {
			return random.nextInt((high - low) + 1) + low;	    	
	    }

	    /**
	     * Swaps the cards at indexes i and j.
	     */
	    public void swapCards(int i, int j) {
	    	Card temp = cards[i];
	    	cards[i] = cards[j];
	    	cards[j] = temp;
	    }

	    /**
	     * Randomly permutes the array of cards.
	     */
	    public void shuffle() {
	    	for(int i = 0 ; i < cards.length - 1 ; i++) {
	    		swapCards(i, randomInt(i, cards.length - 1));
	    	}
	    	System.out.println(Arrays.toString(this.cards));
	    }

	    /**
	     * Finds the index of the lowest card
	     * between low and high inclusive.
	     */
	    public int indexLowest(int low, int high) {
	    	Card lowest = cards[low];
	    	int index = low;
	    	for(int i = low + 1 ; i < high ; i++) {
	    		if(lowest.compareTo(cards[i]) == 1){
	    			index = i;
	    			lowest = cards[i];
	    		}
	    	}    	
	        return index;
	    }

	    /**
	     * Sorts the cards (in place) using selection sort.
	     */
	    public void selectionSort() {
	    	for(int i = 0 ; i < this.cards.length ; i++) {
	    		swapCards(i, indexLowest(i, this.cards.length));
	    	}
	    }

	    /**
	     * Returns a subset of the cards in the deck.
	     */
	    public Ex132 subdeck(int low, int high) {
	    	Ex132 sub = new Ex132(high - low + 1);
	        for (int i = 0; i < sub.cards.length; i++) {
	            sub.cards[i] = this.cards[low + i];
	        }
	        return sub;
	    }

	    /**
	     * Combines two previously sorted subdecks.
	     */
	    public Ex132 merge(Ex132 d1, Ex132 d2) {
	    	int indexD1 = 0;
	    	int indexD2 = 0;
	    	Ex132 newdeck = new Ex132(d1.cards.length + d2.cards.length);
	    	while(indexD1 < d1.cards.length - 1 && indexD2 < d2.cards.length) {
	    		if(d1.cards[indexD1].compareTo(d2.cards[indexD2]) == 1) {
	    			newdeck.cards[indexD1 + indexD2] = d2.cards[indexD2];
	    			indexD2++;
	    		}else {
	    			newdeck.cards[indexD1 + indexD2] = d1.cards[indexD1];
	    			indexD1++;
	    		}
	    	}
	    	for(int i = indexD1 + indexD2 + 1; i < d1.cards.length + d2.cards.length; i++) {
	    		if(indexD1 + 1 != d1.cards.length) {
	    			newdeck.cards[i] = d1.cards[indexD1];
	    			indexD1++;
	    		}else {
	    			newdeck.cards[i] = d2.cards[indexD2];	
	    			indexD2++;
	    		}
	    	}
	    	
	        return newdeck;
	        
	    }

	    /**
	     * Returns a sorted copy of the deck using merge sort.
	     */
	    public Ex132 mergeSort() {
	    	Ex132 d1 = new Ex132(this.cards.length/2);
	    	Ex132 d2 = new Ex132(this.cards.length/2);
	    	
	    	for(int i = 0 ; i < this.cards.length/2; i++) {
	    		d1.cards[i] = this.cards[i];
	    	}  
	    	for(int i = this.cards.length/2; i < this.cards.length; i++) {
    			d2.cards[i - this.cards.length/2] = this.cards[i];
	    	}  
	    	
	    	System.out.println(Arrays.toString(d1.cards));
	    	System.out.println(Arrays.toString(d2.cards));
	    	d1.selectionSort();
	    	d2.selectionSort();
	    	
	    	System.out.println(Arrays.toString(d1.cards));
	    	System.out.println(Arrays.toString(d2.cards));
	    	System.out.println(Arrays.toString(merge(d1,d2).cards));
	    	

	        return merge(d1,d2);
	    }

	    /**
	     * Reorders the cards (in place) using insertion sort.
	     */
	    public void insertionSort() {
	    	
	    	Card temp;
	        for (int i = 1; i < cards.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(cards[j].compareTo(cards[j-1]) == -1){
	                    temp = cards[j];
	                    cards[j] = cards[j-1];
	                    cards[j-1] = temp;
	                }else {
	                	break;
	                }
	            }
	        }
	    	
	    }
	    
	    public static void quickSort(int[] vector, int izquierda, int derecha) {
	        int pivote = vector[izquierda];
	        int i = izquierda;
	        int j = derecha;
	        int auxIntercambio;
	        while (i < j) {
	            while (vector[i] <= pivote && i < j) {
	                i++;
	            }
	            while (vector[j] > pivote) {
	                j--;
	            }
	            if (i < j) {
	                auxIntercambio = vector[i];
	                vector[i] = vector[j];
	                vector[j] = auxIntercambio;
	            }
	        }
	        vector[izquierda] = vector[j];
	        vector[j] = pivote;
	        if (izquierda < j - 1) {
	            quickSort(vector, izquierda, j - 1);
	        }
	        if (j + 1 < derecha) {
	            quickSort(vector, j + 1, derecha);
	        }
	    }
	    
	    public Ex132 Quicksort() {
	    	Ex132 d1 = new Ex132(this.cards.length/2);
	    	Ex132 d2 = new Ex132(this.cards.length/2);
	    	
	    	for(int i = 0 ; i < this.cards.length/2; i++) {
	    		d1.cards[i] = this.cards[i];
	    	}  
	    	for(int i = this.cards.length/2; i < this.cards.length; i++) {
    			d2.cards[i - this.cards.length/2] = this.cards[i];
	    	}  
	    	
	    	System.out.println(Arrays.toString(d1.cards));
	    	System.out.println(Arrays.toString(d2.cards));
	    	d1.selectionSort();
	    	d2.selectionSort();
	    	
	    	System.out.println(Arrays.toString(d1.cards));
	    	System.out.println(Arrays.toString(d2.cards));
	    	System.out.println(Arrays.toString(merge(d1,d2).cards));
	    	

	        return merge(d1,d2);
	    }

	}
