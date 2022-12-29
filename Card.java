public class Card {
    private String suit;
    private String value;
    private int point;
    private boolean pisti;

    public Card() {
        suit = "";
        value = "";
        point = 0;
        pisti = false;
    }

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.pisti = false;
        int point = 0;
        if(suit.equals("♦") && value.equals("10")) {
            point = 3;
        } else if(suit.equals("♣") && value.equals("2")) {
            point = 2;
        } else {
            point = 1;
        }
        this.point = point;
    }

    public void print() {
        System.out.print(this.suit+this.value+" ");
    }

    public String getSuit() {
        return this.suit;
    }

    public String getValue() {
        return this.value;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean getPisti() {
        return this.pisti;
    }

    public void setPisti(boolean pisti) {
        this.pisti = pisti;
    }
}