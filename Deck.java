import java.util.Random;

public class Deck {
    public static String[] suits = {"♠", "♣", "♥", "♦"};
    public static String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private Card[] deck;
    private int top;

    public Deck() {
        this.deck = new Card[52];
        int i = 0;
        for(String suit : Deck.suits) {
            for(String value : Deck.values) {
                this.deck[i++] = new Card(suit, value);
            }
        }
        this.top = 0;
    }

    public void shuffle() {
        Random r = new Random();
        Card c;
        for(int i = 0; i < deck.length; i++) {
            int j = r.nextInt(deck.length);
            c = deck[i];
            deck[i] = deck[j];
            deck[j] = c;
        }
    }

    public void cut(int index) {
        if(index < 1 || index > 51)
            return;
        Card[] c = new Card[index];
        for(int i = 0; i < index; i++) {
            c[i] = this.deck[i];
        }
        for(int i = index; i < deck.length; i++) {
            this.deck[i-index] = this.deck[i];
        }
        for(int i = 0; i < c.length; i++) {
            this.deck[deck.length-index+i] = c[i];
        }
    }

    public Card[] getDeck() {
        return this.deck;
    }

    public Card[] getTopFour() {
        Card[] c = new Card[4];
        for(int i = 0; i < 4; i++) {
            c[i] = this.deck[this.top+i];
        }
        this.top += 4;
        return c;
    }

    public boolean isEmpty() {
        if(this.top == 52)
            return true;
        return false;
    }
}