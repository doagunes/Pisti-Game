import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Game {
    private Deck deck;
    private Board board;
    private Player player;
    private Player com;
    private Scanner s;

    public Game() {
        this.deck = new Deck();
        this.board = new Board();
        this.player = new Player();
        this.com = new Player();
    }

    public void play() {
        s = new Scanner(System.in);

        System.out.println("Welcome, please enter your name");
        String name = s.nextLine();
        this.player.setName(name);
        this.com.setName("Computer");

        this.deck.shuffle();
        System.out.println("Please cut the deck (enter a number between 1-51)");
        int index = s.nextInt();
        this.deck.cut(index);

        Card[] cards;
        cards = deck.getTopFour();
        for(int i = 0; i < 4; i++)
            this.board.addCard(cards[i]);

            do{
                this.player.addHand(this.deck.getTopFour());
                this.com.addHand(this.deck.getTopFour());

                for(int i = 0; i < 4; i++) {
                    processCard(this.player, playPlayer());
                    processCard(this.com, playComputer());
                }
            } while(!this.deck.isEmpty());
            calculateScores();

        s.close();
    }

    private int playPlayer() {
        System.out.println("----------Board----------");
        this.board.print();
        System.out.println("------" + this.player.getName() + "'s hand------");
        this.player.print();
        System.out.println("Chose one index to play (0-3)");
        return s.nextInt();
    }

    private int playComputer() {
        Card[] hand = this.com.getHand();
        Card topCard = this.board.getTop();
        for(int i = 0; i < 4; i++) {
            if(hand[i] != null) {
                if(topCard == null)
                    return i;
                else if(topCard.getValue().equals(hand[i].getValue()))
                    return i;
            }
        }
        for(int i = 0; i < 4; i++) {
            if(hand[i] != null)
                return i;
        }

        return 0;
    }

    private void processCard(Player player, int index) {
        Card topCard = this.board.getTop();
        Card card = player.playCard(index);
        int c = board.getCardCount();
        if(topCard == null)
            board.addCard(card);
        else {
            if(card.getValue().equals(topCard.getValue())) {
                if(c == 1)
                    card.setPisti(true);
                this.board.addCard(card);
                player.acquire(this.board.clear());
            } else if(card.getValue().equals("J")) {
                this.board.addCard(card);
                player.acquire(this.board.clear());
            } else {
                this.board.addCard(card);
            }
        }
    }

    private void calculateScores() {
        System.out.println("Game Over");
        int player_score = this.player.calculateScore();
        int com_score = this.com.calculateScore();
        int player_card_count = this.player.getAcquiredCount();
        int com_card_count = this.com.getAcquiredCount();
        if(player_card_count > com_card_count)
            player_score += 3;
        if(player_card_count < com_card_count)
            com_score += 3;
        System.out.println(this.player.getName() + "'s score: " + player_score);
        System.out.println("Computer's score: " + com_score);
        if(player_score > com_score) {
            System.out.println("Winner: " + this.player.getName());
            highScore(player_score);
        }
        else if(player_score < com_score)
            System.out.println("Winner: Computer");
        else
            System.out.println("Draw");

    }

    private void highScore(int score) {
        String[] names = new String[11];
        int[] scores = new int[11];
        int i = 0;
        BufferedReader reader;
		try {
            File f = new File("high_score_list.txt");
            if(!f.exists())
                f.createNewFile();

			reader = new BufferedReader(new FileReader("high_score_list.txt"));
			String line = reader.readLine();
			while (line != null) {
				if(i > 9)
                    break;
                names[i] = line.substring(0, line.lastIndexOf(" "));
                scores[i++] = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1, line.length()));

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Read error");
		}

        for(i = 0; i < 10; i++) {
            if(scores[i] < score) {
                for(int j = 10; j > i; j--) {
                    names[j] = names[j-1];
                    scores[j] = scores[j-1];
                }
                names[i] = this.player.getName();
                scores[i] = score;
                break;
            }
        }

        BufferedWriter writer;
        String s = "";
        try {
            writer = new BufferedWriter(new FileWriter("high_score_list.txt"));
            for(i = 0; i < 10; i++) {
                if(names[i] == null)
                    break;
                s = names[i] + " " + scores[i] + "\n";
                writer.write(s);
            }
            writer.close();
        } catch (IOException e) {
			System.out.println("Write error");
		}
    }
}