package fiveDrawPoker;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameController {
    
    private Scanner scanner;
    
    public GameController() {
        scanner = new Scanner(System.in);
    }
    public Scanner getScanner() {
        return scanner;
    }
    
    public HashSet<Integer> selectCards() {
        System.out.println("どのカードを選択しますか？");
        String[] nums = scanner.nextLine().split(" ");
        HashSet<Integer> choiceNums = new HashSet<>();
        for (String num : nums) {
            choiceNums.add(Integer.parseInt(num));
        }
        return choiceNums;
    }

//    public int checkHand(PlayerHand hand) {
//
//    }

    public void executeGame() {
        Deck deck = new Deck();
        deck.shuffle();
        PlayerHand hand_01 = new PlayerHand(deck.getCards());
        hand_01.displayHand();
        HashSet<Integer> choiceNum = selectCards();
        hand_01.ChangeCards(choiceNum, deck.getCards());
//        PlayerHand hand_02 = new PlayerHand(deck.getCards());
        
        hand_01.displayHand();
//        hand_02.displayHand();
    }
}
