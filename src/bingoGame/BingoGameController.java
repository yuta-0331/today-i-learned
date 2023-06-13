package bingoGame;

import lesson.MyConsole;
import java.util.ArrayList;

public class BingoGameController {
    private ArrayList<BingoGameBoard> gameBoards;

    public BingoGameController(ArrayList<BingoGameBoard> gameBoards) {
        this.gameBoards = gameBoards;
    }

    public ArrayList<BingoGameBoard> getGameBoard() {
        return gameBoards;
    }

    //引数のindex要素に、重複なしで番号を格納するメソッド(盤面の作成、当たり番号の抽選で使用)
    //range: 取り得る値の範囲, adjust: 取り得る値の調整,
    public static void generateArrayWithUniqueNumber(int index, int[] array, int range, int adjust) {
        while (true) {
            boolean continueFlag = false;
            int tmp = (int) (Math.random() * range) + adjust;
            for (int i = 0; i < index; i++) {
                if (array[i] == tmp) {
                    continueFlag = true;
                    break;
                }
            }
            if (!continueFlag) {
                array[index] = tmp;
                break;
            }
        }
    }
    public void executeGame() {
        int[] hitNumbers = new int[75];
        ArrayList<BingoGameBoard> completeBoards = new ArrayList<>();
        for (int i = 0; i < hitNumbers.length; i++) {
            //盤面の出力
            for (BingoGameBoard gameBoard : gameBoards) {
                gameBoard.printBoard();
            }
            MyConsole.readLine();
            //番号の抽選
            BingoGameController.generateArrayWithUniqueNumber(i, hitNumbers, 75, 1);
            System.out.println("抽選番号:" + hitNumbers[i]);
            //当たり番号が盤面に含まれるかチェック
            for (BingoGameBoard gameBoard : gameBoards) {
                gameBoard.checkHitNumber(hitNumbers[i]);
            }
            for (BingoGameBoard gameBoard : gameBoards) {
                if (gameBoard.checkAlign()) {
                    completeBoards.add(gameBoard);
                }
            }
            if (completeBoards.size() != 0) {
                break;
            }
        }
        for (BingoGameBoard gameBoard : gameBoards) {
            gameBoard.printBoard();
        }
        if (completeBoards.size() == 1) {
            System.out.println(completeBoards.get(0).getName() + "の勝利");
        } else {
            for (BingoGameBoard gameBoard : completeBoards) {
                System.out.print(gameBoard.getName() + " ");
            }
            System.out.println("の引き分け");
        }
    }
}
