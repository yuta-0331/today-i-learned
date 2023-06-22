package fiveDrawPoker;

import java.util.ArrayList;
import java.util.Collections;
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

    public void sortHand() {
        // s > c > h > dにソート
        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = 0; j < hand.size()- 1 - i; j++) {
                if (hand.get(j).getSuitInt() > hand.get(j + 1).getSuitInt()) {
                    Collections.swap(hand, j, j + 1);
                }
            }
        }
        // 各suitの中で番号順にする
        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = 0; j < hand.size() - 1 - i; j++) {
                if (
                        hand.get(j).getNumber() > hand.get(j + 1).getNumber() 
                        && hand.get(j).getSuitInt() == hand.get(j + 1).getSuitInt() 
                        ) {
                    
                    Collections.swap(hand, j, j + 1);
                }
            }
        }
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
            System.out.println(num);
            hand.remove(num - 1  - index++);
        }
        for (int i = 0; i < choiceNum.size(); i++) {
            drawOneCard(cards);
        }
    }
}
