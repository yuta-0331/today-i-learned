package fiveDrawPoker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class PlayerHand {
    private ArrayList<Card> hand;

    // インスタンス化時に山札から５枚ドロー
    public PlayerHand(ArrayList<Card> cards) {
        hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            drawOneCard(cards);
        }
    }
    //Getter
    public ArrayList<Card> getHand() {
        return hand;
    }

    //カードを一枚ドロー
    public void drawOneCard(ArrayList<Card> cards) {
        hand.add(cards.get(0));
        cards.remove(0);
    }

    //手札の表示
    public void displayHand() {
        for (int i = 0; i < 5; i++) {
            System.out.println("[" + (i + 1) + "] " + hand.get(i).getSuit() + ": " + hand.get(i).getNumberStr() );
        }
        System.out.println();
    }

    //手札の交換
    public void ChangeCards(HashSet<Integer> choiceNum, ArrayList<Card> cards) {
        int index = 0;
        for (Integer num : choiceNum) {
            hand.remove(num - 1  - index++);
        }
        for (int i = 0; i < choiceNum.size(); i++) {
            drawOneCard(cards);
        }
    }
}
