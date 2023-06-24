package fiveDrawPoker;

public class HandRanking {
    private int firstRanking;
    private int secondRanking;

    public HandRanking(PlayerHand hand) {
        PlayerHand sortedHand = hand.sortHand();
        PlayerHand handSortedBySuit = sortedHand.sortHandBySuit();
        handSortedBySuit.displayHand();
        sortedHand.displayHand();

        //ロイヤルストレートフラッシュ
        if (handSortedBySuit.getHand().get(0).getSuitInt() == handSortedBySuit.getHand().get(4).getSuitInt()
                && sortedHand.getHand().get(0).getNumber() == 1
                && sortedHand.getHand().get(1).getNumber() == 10
                && sortedHand.getHand().get(2).getNumber() == 11
                && sortedHand.getHand().get(3).getNumber() == 12
                && sortedHand.getHand().get(4).getNumber() == 13
        ) {
            firstRanking = 1;
        }
        //ストレートフラッシュ
        else if (handSortedBySuit.getHand().get(0).getSuitInt() == handSortedBySuit.getHand().get(4).getSuitInt()
                && sortedHand.getHand().get(1).getNumber() == sortedHand.getHand().get(0).getNumber() + 1
                && sortedHand.getHand().get(2).getNumber() == sortedHand.getHand().get(0).getNumber() + 2
                && sortedHand.getHand().get(3).getNumber() == sortedHand.getHand().get(0).getNumber() + 3
                && sortedHand.getHand().get(4).getNumber() == sortedHand.getHand().get(0).getNumber() + 4

        ) {
            firstRanking = 2;
        }
        //フォーカード
        else if (sortedHand.getHand().get(0).getNumber() == sortedHand.getHand().get(1).getNumber()
                && sortedHand.getHand().get(0).getNumber() == sortedHand.getHand().get(2).getNumber()
                && sortedHand.getHand().get(0).getNumber() == sortedHand.getHand().get(3).getNumber()
                || sortedHand.getHand().get(1).getNumber() == sortedHand.getHand().get(2).getNumber()
                && sortedHand.getHand().get(1).getNumber() == sortedHand.getHand().get(3).getNumber()
                && sortedHand.getHand().get(1).getNumber() == sortedHand.getHand().get(4).getNumber()
        ) {
            firstRanking = 3;
        }
        //フルハウス
        else if (sortedHand.getHand().get(0).getNumber() == sortedHand.getHand().get(1).getNumber()
                && sortedHand.getHand().get(0).getNumber() == sortedHand.getHand().get(2).getNumber()
                && sortedHand.getHand().get(3).getNumber() == sortedHand.getHand().get(4).getNumber()
                || sortedHand.getHand().get(0).getNumber() == sortedHand.getHand().get(1).getNumber()
                && sortedHand.getHand().get(2).getNumber() == sortedHand.getHand().get(3).getNumber()
                && sortedHand.getHand().get(2).getNumber() == sortedHand.getHand().get(4).getNumber()

        ) {
            firstRanking = 4;
        }
        //フラッシュ
        else if (handSortedBySuit.getHand().get(0).getSuitInt() == handSortedBySuit.getHand().get(4).getSuitInt()) {
            firstRanking = 5;
        }
    }

    public int getFirstRanking() {
        return firstRanking;
    }
}
