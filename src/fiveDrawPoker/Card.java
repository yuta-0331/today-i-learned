package fiveDrawPoker;

public class Card {
    private int number;
    private Suit suit;
    public enum Suit {spade, clover, heart, diamond};
    
    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }
    
    public int getNumber() {
        return number;
    }
    public Suit getSuit() {
        return suit;
    }
}
