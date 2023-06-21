package fiveDrawPoker;

public class Card {
    private int number;
    private Suit suit;
    public enum Suit {S, C, H, D};
    
    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }
    
    public String getNumberStr() {
        switch (number) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return Integer.valueOf(number).toString();
        }
    }
    public Suit getSuit() {
        return suit;
    }
}