public class Player {
    private Card[] hand;
    private Card[] acquired;
    private int acq_count;
    private String name;

    public Player() {
        this.hand = new Card[4];
        this.acquired = new Card[52];
        this.acq_count = 0;
        this.name = "";
    }

    public void print() {
        System.out.println("0\t1\t2\t3\t");
        for(int i = 0; i < this.hand.length; i++) {
            if(hand[i] != null)
                hand[i].print();
            System.out.print("\t");
        }
        System.out.println();
    }

    public Card[] getHand() {
        return this.hand;
    }

    public void acquire(Card[] c) {
        for(int i = 0; i < c.length; i++) {
            acquired[acq_count + i] = c[i];
        }
        this.acq_count += c.length;
    }

    public void addHand(Card[] c) {
        this.hand = c;
    }

    public Card playCard(int i) {
        Card c = this.hand[i];
        this.hand[i] = null;
        return c;
    }

    public int calculateScore() {
        int score = 0;
        for(int i = 0; i < this.acq_count; i++) {
            if(acquired[i].getPisti() == true)
                score += 10;
            score += acquired[i].getPoint();
        }
        return score;
    }

    public int getAcquiredCount() {
        return this.acq_count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}