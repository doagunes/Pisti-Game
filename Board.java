public class Board {
    private Card[] cards;
    private int card_count;

    public Board() {
        this.cards = new Card[52];
        this.card_count = 0;
    }
    
    public int getCardCount() {
        return this.card_count;
    }

    public Card getTop() {
        if(this.card_count == 0)
            return null;
        return this.cards[this.card_count - 1];
    }

    public void print() {
        if(this.card_count == 0) {
            System.out.println();
            return;
        }
        this.cards[this.card_count-1].print();
        System.out.println();
        for(int i = this.card_count-2; i >= 0; i--) {
            this.cards[i].print();
        }
        System.out.println();
    }

    public void addCard(Card c) {
        this.cards[this.card_count++] = c;
    }

    public Card[] clear() {
        Card[] c = new Card[this.card_count];
        for(int i = 0; i < this.card_count; i++) {
            c[i] = this.cards[i];
            this.cards[i] = null;
        }
        this.card_count = 0;
        return c;
    }
}