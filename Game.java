import java.util.Scanner;

public class Game {
	
	String player1[] = Deck.player1;
	
	Deck dealcard = new Deck();
	
	Scanner sc = new Scanner(System.in);
	
	String board[] = Deck.board;
	String tableBoard = board[3];
	String firstCard = player1[0];
	String secondCard = player1[1];
	String thirdCard = player1[2];
	String fourthCard = player1[3];
	
	
	public static int x;
	
	public void selectCard() {;
		
		System.out.println(board[3]);
		System.out.println("Please select card..");
		x = sc.nextInt();
		System.out.println("The card you chose: " + player1[x - 1]);
		
		
		if(x == 1 && player1[x - 1].charAt(0) == board[3].charAt(0)) {
			System.out.println("On the board" + player1[x - 1] );
			System.out.println("pişti");
			player1[0] = player1[1];
			player1[1] = player1[2];
			player1[2] = player1[3];
			player1[3] = null;
			for(int i=0;i<player1.length;i++) {
				if(player1[i] != null) {
					System.out.println(player1[i]);
				}
			}
			
			selectCard();
			
			
		}else if(x ==1 && player1[x - 1].charAt(0) != board[3].charAt(0)) {
			System.out.println("On the board" + player1[x - 1]);
			player1[0] = player1[1];
			player1[1] = player1[2];
			player1[2] = player1[3];
			player1[3] = null;
			
			for(int i=0;i<player1.length;i++) {
				if(player1[i] != null) {
					System.out.println(player1[i]);
				}
			}
			if(player1[0] == null) {
				dealcard.dealCards();
				System.out.println("Deal cards..");
				dealcard.dealCards();
				selectCard();
			}
			
			selectCard();
		}
	
		
		
		if(x == 2 && player1[x - 1].charAt(0) == board[3].charAt(0)) {
			
			System.out.println("On the board" + player1[x - 1]);
			player1[0] = player1[1];
			player1[1] = player1[2];
			player1[2] = player1[3];
			player1[3] = null;
			
			for(int i=0;i<player1.length;i++) {
				
				if(player1[i] != null) {
					System.out.println(player1[i]);
					
					
				}
			}
			
			selectCard();
			
		}else if(x == 2 && player1[x - 1].charAt(0) != board[3].charAt(0)) {
			
			player1[0] = player1[1];
			player1[1] = player1[2];
			player1[2] = player1[3];
			player1[3] = null;
			
			
			for(int i=0;i<player1.length;i++) {
				if(player1[i] != null) {
					System.out.println(player1[i]);
				}
			}
			
			System.out.println("On the board" + player1[x - 1]);
			
			selectCard();
			
		}
		
		if(x == 3 && player1[x - 1].charAt(0) == board[3].charAt(0)) {
			System.out.println("On the board" + player1[x - 1]);
			player1[0] = player1[1];
			player1[1] = player1[2];
			player1[2] = player1[3];
			player1[3] = null;
			
			for(int i=0; i<player1.length;i++) {
				if(player1[i] != null) {
					System.out.println(player1[i]);
				}
			}
			
			System.out.println("On the board" + player1[x - 1]);
			selectCard();
			
		}else if(x == 3 && player1[x - 1].charAt(0) != board[3].charAt(0)) {
			
			player1[0] = player1[1];
			player1[1] = player1[2];
			player1[2] = player1[3];
			player1[3] = null;
			
			
			for(int i=0;i<player1.length;i++) {
				if(player1[i] != null) {
					System.out.println(player1[i]);
				}
			}
			
			System.out.println("On the board" + player1[x - 1]);
			
			selectCard();
			
		}
		
		
	
		
	
	
	
	}

}
