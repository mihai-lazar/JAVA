package exercise17;

public class Ex135 {
	
	
	
	public static void main(String[] args)
	{
		Ex132 deck = new Ex132();
		
		System.out.println(deck);
		System.out.println(deck.toString(1));
		
		deck.shuffle();
		
		deck.mergeSort();
		
		
		
		deck.shuffle();
		deck.insertionSort();
		System.out.println(deck.toString(1));
		
	}

}
