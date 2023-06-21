package fiveDrawPoker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    private ArrayList<Card> cards;
    
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    //インスタンス化時にカードの山を作成
    public Deck() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i, Suit.suit.C));
        }
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i, Suit.suit.S));
        }
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i, Suit.suit.H));
        }
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i, Suit.suit.D));
        }
        
        this.cards = cards;
    }
    //シャッフル
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
