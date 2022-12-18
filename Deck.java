import java.util.Random;
import java.util.Scanner;

public class Deck {
	
      public static String[] deck = new String[52];
      public static String[] player1 = new String[4];
      public static String[] computer = new String[4];
      public static String[] board = new String[4];
 	  

	  public Deck() {
	    
		String[] suits = {"♠", "♥", "♣", "♦"};
		String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	    
	    
	    for (int i = 0; i < suits.length; i++) {
	      for (int j = 0; j < values.length; j++) {
	        deck[i * values.length + j] = values[j] + " " + suits[i];
	      }
	    }
	  }  
	  

	  public void shuffle() {
	    // Shuffle the deck
	    Random random = new Random();
	    
	    for (int i = 0; i < deck.length; i++) {
	    	
	      int index = random.nextInt(deck.length);
	      String temp = deck[i];
	      deck[i] = deck[index];
	      deck[index] = temp;
	    }
	    
	    for(int i = 0; i < deck.length ; i++ ) {
	    	
	    	System.out.println(deck[i]);
	    }
	  }
	  
	  
	  public void cut() {
		
		  Scanner sc = new Scanner(System.in);
		    System.out.println("Enter the cut point: ");
		    int cutPoint = sc.nextInt();

		    // Cut the deck at the specified point
		    String[] cutDeck = new String[deck.length];
		    for (int i = 0; i < cutDeck.length; i++) {
		      cutDeck[i] = deck[(i + cutPoint) % deck.length];
		    }

		    // Print the cut deck
		    System.out.println("Cut deck: ");
		    for (int i = 0; i < cutDeck.length; i++) {
		      System.out.println(cutDeck[i] + " ");
		    }
		    System.out.println();
	  }  
	  
	  
	  
	  public int counter = 0 ;
	  public int counter2 = 0;
	  public int c = 0;
	  
	  
	  public void boardCards() {
		  
		  int j = 0;
		  for(int i = 8; i < 12; i++) {
			  
			  board[j] = deck[i];
			  j++;
		  }
		  
		  System.out.println("Cards from the table: " + board[j-1]);
		  counter+=4;
	  }
	  
	  public void dealCards() {
		  
		  for(int i = counter; i < counter + 8; i++) {
			  if(deck[i] != null) {
				  
				  if(i % 2 != 0) {
					  player1[counter2] = deck[i];
					  deck[i] = null;
					  counter2++;
				  }
				  else {
					  computer[c] = deck[i];
					  deck[i] = null;
					  c++;
				  }
			  }
			  
		  }
		  
		  counter += 8;
		  
		  for(int i=0; i < player1.length; i++) {
			  System.out.println("player 1 cards: " + " " + player1[i]);
		  }
		  
		  for(int i=0; i < computer.length; i++) {
			  System.out.println("computer cards: " + " " + computer[i]);
		  }
	  }
	  
	  
	  
}		  
		  
		  
	  
	  
	   
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	    
		  

	  		
		    
		  

	
	
	
	
	
		
		
	
		
		
	
	
	


