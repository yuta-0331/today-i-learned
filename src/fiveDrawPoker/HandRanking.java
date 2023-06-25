package fiveDrawPoker;

public class HandRanking {
    private int firstRanking;
    private int secondRanking;

    public HandRanking(PlayerHand hand) {
        //ロイヤルストレートフラッシュ
        if (hand.sortHandBySuit().getHand().get(0).getSuitInt() == hand.getHand().get(4).getSuitInt()
                && hand.sortHand().sortHand().getHand().get(0).getNumber() == 1
                && hand.getHand().get(1).getNumber() == 10
                && hand.getHand().get(2).getNumber() == 11
                && hand.getHand().get(3).getNumber() == 12
                && hand.getHand().get(4).getNumber() == 13
        ) {
            firstRanking = 1;
        }
        //ストレートフラッシュ
        else if (hand.sortHandBySuit().getHand().get(0).getSuitInt() == hand.getHand().get(4).getSuitInt()
                && hand.sortHand().getHand().get(1).getNumber() == hand.getHand().get(0).getNumber() + 1
                && hand.getHand().get(2).getNumber() == hand.getHand().get(0).getNumber() + 2
                && hand.getHand().get(3).getNumber() == hand.getHand().get(0).getNumber() + 3
                && hand.getHand().get(4).getNumber() == hand.getHand().get(0).getNumber() + 4

        ) {
            firstRanking = 2;
        }
        //フォーカード
        else if (hand.sortHand().getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(3).getNumber()
                || hand.getHand().get(1).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(1).getNumber() == hand.getHand().get(3).getNumber()
                && hand.getHand().get(1).getNumber() == hand.getHand().get(4).getNumber()
        ) {
            firstRanking = 3;
        }
        //フルハウス
        else if (hand.sortHand().getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(3).getNumber() == hand.getHand().get(4).getNumber()
                || hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(2).getNumber() == hand.getHand().get(3).getNumber()
                && hand.getHand().get(2).getNumber() == hand.getHand().get(4).getNumber()

        ) {
            firstRanking = 4;
        }
        //フラッシュ
        else if (hand.sortHandBySuit().getHand().get(0).getSuitInt() == hand.getHand().get(4).getSuitInt()) {
            firstRanking = 5;
        }
    }

    public int getFirstRanking() {
        return firstRanking;
    }
}
