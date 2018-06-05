package exercise15;

public class Ex113 { //Tile
	char letter;
	int value;
	
	public Ex113(char letter, int value) {
		this.letter = letter;
		this.value = value;	
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public char getLetter() {
		return letter;	
	}
	
	public void setValue(char value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;	
	}
	
	public String toString() {
		return "letter: " + letter + " and value: " + value;
	}
	
	public boolean equals(Ex113 comparacion) {
		return this.letter == comparacion.letter
				&& this.value == comparacion.value;		
	}
	
	
	public static void printTile(Ex113 tile) {
		System.out.println("printTile : letter: " + tile.letter + " and value: " + tile.value);
	}
	
	public static void testTile() {
		Ex113 tile = new Ex113('Z', 10);
		printTile(tile);
		System.out.println("toString  : " + tile.toString());
		System.out.println("equals    : " + tile.equals(tile));
	}
	
	
	
	public static void main(String[] args) 
	{
		testTile();		
	}
	
	

}


