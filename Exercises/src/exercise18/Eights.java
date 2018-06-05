package exercise18;

import java.util.ArrayList;
import java.util.Scanner;

public class Eights {
	private Hand drawPile;
	private Hand discardPile;
	ArrayList<Player> players;
	private Scanner in;
	
	public Eights(int jugadores) {
		Deck deck = new Deck("Deck");
		deck.shuffle();
		
		int handSize = 5;
		players.add(new Player("Allen"));
		deck.deal(players.get(0).getHand(), handSize);
		players.add(new Player("Juan"));
		deck.deal(players.get(1).getHand(), handSize);

		
		discardPile = new Hand("Discards");
		deck.deal(discardPile, 1);
		
		drawPile = new Hand("Draw pile");
		deck.dealAll(drawPile);
		
		in = new Scanner(System.in);
	}
	
	public boolean isDone() {
		return players.get(0).getHand().empty() || players.get(2).getHand().empty();
	}
	
	public void reshuffle() {
		Card prev = discardPile.popCard();
		discardPile.dealAll(drawPile);
		discardPile.addCard(prev);
		drawPile.shuffle();
	}
	
	public Card draw() {
		if (drawPile.empty()) {
			reshuffle();
		}
		return drawPile.popCard();
	}
	
	public Player nextPlayer(Player current) {
		if (current == players.get(0)) {
			return players.get(1);
		} else {
			return players.get(0);
		}
	}
	
	public void displayState() {
		players.get(0).display();
		players.get(0).display();
		discardPile.display();
		System.out.println("Draw pile:");
		System.out.println(drawPile.size() + " cards");
	}
	
	public void waitForUser() {
		in.nextLine();
	}
	
	public void takeTurn(Player player) {
		Card prev = discardPile.last();
		Card next = player.play(this, prev);
		discardPile.addCard(next);
		
		System.out.println(player.getName() + " plays " + next);
		System.out.println();
	}
	
	public void playGame() {
		Player player = players.get(0);
		// keep playing until there's a winner
		while (!isDone()) {
			displayState();
			waitForUser();
			takeTurn(player);
			player = nextPlayer(player);
		}
		// display the final score
		players.get(0).displayScore();
		players.get(0).displayScore();
	}



	
}
