package fiveDrawPoker;

public class HandRanking {
    private int firstRanking;
    private int secondRanking;

    public HandRanking(PlayerHand hand) {
        //フラッシュを含む役
        if (hand.getHand().get(0).getSuitInt() == hand.getHand().get(1).getSuitInt()
                && hand.getHand().get(0).getSuitInt() == hand.getHand().get(2).getSuitInt()
                && hand.getHand().get(0).getSuitInt() == hand.getHand().get(3).getSuitInt()
                && hand.getHand().get(0).getSuitInt() == hand.getHand().get(4).getSuitInt()
        ) {
            //ロイヤルストレートフラッシュ
            if (hand.getHand().get(0).getNumber() == 1
                    && hand.getHand().get(1).getNumber() == 10
                    && hand.getHand().get(2).getNumber() == 11
                    && hand.getHand().get(3).getNumber() == 12
                    && hand.getHand().get(4).getNumber() == 13
            ) {
                firstRanking = 1;
            }
            //ストレートフラッシュ
            else if (hand.getHand().get(1).getNumber() == hand.getHand().get(0).getNumber() + 1
                    && hand.getHand().get(2).getNumber() == hand.getHand().get(0).getNumber() + 2
                    && hand.getHand().get(3).getNumber() == hand.getHand().get(0).getNumber() + 3
                    && hand.getHand().get(4).getNumber() == hand.getHand().get(0).getNumber() + 4
            ) {
                firstRanking = 2;
            }
            //フラッシュ
            else {
                firstRanking = 5;
            }
        }
        //フォーカード
        else if (hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(3).getNumber()
                || hand.getHand().get(1).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(1).getNumber() == hand.getHand().get(3).getNumber()
                && hand.getHand().get(1).getNumber() == hand.getHand().get(4).getNumber()
        ) {
            firstRanking = 3;
        }
        //フルハウス
        else if (hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(3).getNumber() == hand.getHand().get(4).getNumber()
                || hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(2).getNumber() == hand.getHand().get(3).getNumber()
                && hand.getHand().get(2).getNumber() == hand.getHand().get(4).getNumber()
        ) {
            firstRanking = 4;
        }
        //ストレート
        else if (hand.getHand().get(0).getNumber() == 1
                && hand.getHand().get(1).getNumber() == 10
                && hand.getHand().get(2).getNumber() == 11
                && hand.getHand().get(3).getNumber() == 12
                && hand.getHand().get(4).getNumber() == 13
                || hand.getHand().get(1).getNumber() == hand.getHand().get(0).getNumber() + 1
                && hand.getHand().get(2).getNumber() == hand.getHand().get(0).getNumber() + 2
                && hand.getHand().get(3).getNumber() == hand.getHand().get(0).getNumber() + 3
                && hand.getHand().get(4).getNumber() == hand.getHand().get(0).getNumber() + 4
        ) {
            firstRanking = 6;
        }
        //スリーカード
        else if (hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(0).getNumber() == hand.getHand().get(2).getNumber()
                || hand.getHand().get(1).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(1).getNumber() == hand.getHand().get(3).getNumber()
                || hand.getHand().get(2).getNumber() == hand.getHand().get(3).getNumber()
                && hand.getHand().get(2).getNumber() == hand.getHand().get(4).getNumber()
        ) {
            firstRanking = 7;
        }
        //ツーペア
        else if (hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(2).getNumber() == hand.getHand().get(3).getNumber()
                || hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                && hand.getHand().get(3).getNumber() == hand.getHand().get(4).getNumber()
                || hand.getHand().get(1).getNumber() == hand.getHand().get(2).getNumber()
                && hand.getHand().get(3).getNumber() == hand.getHand().get(4).getNumber()
        ) {
            firstRanking = 8;
        }
        //ワンペア
        else if (hand.getHand().get(0).getNumber() == hand.getHand().get(1).getNumber()
                || hand.getHand().get(1).getNumber() == hand.getHand().get(2).getNumber()
                || hand.getHand().get(2).getNumber() == hand.getHand().get(3).getNumber()
                || hand.getHand().get(3).getNumber() == hand.getHand().get(4).getNumber()
        ) {
            firstRanking = 9;
        } else {
            firstRanking = 10;
        }
    }

    public void displayHandRanking() {
        String handRanking;
        switch (firstRanking) {
            case 1:
                handRanking = "Royal Flush";
                break;
            case 2:
                handRanking = "Straight Flush";
                break;
            case 3:
                handRanking = "For of a Kind";
                break;
            case 4:
                handRanking = "Full House";
                break;
            case 5:
                handRanking = "Flush";
                break;
            case 6:
                handRanking = "Straight";
                break;
            case 7:
                handRanking = "Three of a Kind";
                break;
            case 8:
                handRanking = "Two Pair";
                break;
            case 9:
                handRanking = "One Pair";
                break;
            default:
                handRanking = "No Pair";
                break;
        }
        System.out.println(handRanking);
    }

    public int getFirstRanking() {
        return firstRanking;
    }
}
