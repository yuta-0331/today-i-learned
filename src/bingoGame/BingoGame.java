package bingoGame;

import java.util.ArrayList;

public class BingoGame {
    private static BingoGameController gameController;

    public static BingoGameController getGameController() {
        return gameController;
    }

    public static void main(String[] args) {
        // ゲーム盤面を作成
        ArrayList<BingoGameBoard> gameBoards = new ArrayList<>();
        BingoGameBoard playerOneBoard = new BingoGameBoard();
        BingoGameBoard playerTwoBoard = new BingoGameBoard();
        gameBoards.add(playerOneBoard);
        gameBoards.add(playerTwoBoard);

        //ボードを作成
        BingoGameController controller = new BingoGameController(gameBoards);
        //ゲーム実行
        controller.executeGame();
    }
}