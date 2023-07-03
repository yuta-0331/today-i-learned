package bingoGame;

import lesson.MyConsole;

class BingoGameBoard {
    private int[][] gameBoard;
    private String name;

    public String getName() {
        return name;
    }

    //盤面の行配列を引数に格納するメソッド
    public int[][] createBoardAndDecideName() {
        int[][] board = new int[5][5];
        System.out.println("名前を入力してください");
        name = MyConsole.readLine();
        int[][] columnNumbers = new int[5][5];
        for (int i = 0, j = 1; i < 5; i++, j += 15) {
            for (int k = 0; k < 5; k++) {
                BingoGameController.generateArrayWithUniqueNumber(k, columnNumbers[i], 15, j);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = columnNumbers[j][i];
            }
        }
        board[2][2] = 0;
        return board;
    }
    //盤面を出力するメソッド
    public void printBoard() {
        System.out.println("player: " + name);
        System.out.println("---------------------");
        System.out.println("| B | I | N | G | O |");
        System.out.println("---------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String temp;
                if (gameBoard[i][j] > 0) {
                    temp = gameBoard[i][j] < 10 ? ("| " + gameBoard[i][j] + " ") : ("| " + gameBoard[i][j]);
                } else {
                    temp = "| ■ ";
                }
                System.out.print(j == 4 ? temp + "|" + "\n" : temp);
            }
        }
        System.out.println("---------------------");
    }
    //引数の要素にnumを持っていてたら、値を0に置換するメソッド
    public void checkHitNumber(int hitNum) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == hitNum) {
                    gameBoard[i][j] = 0;
                    System.out.println(getName() + ": Hit!");
                    return;
                }
            }
        }
        System.out.println(getName() + ": Deviate");
    }
    //盤面がクリア条件を満たしていないかチェック
    public boolean checkAlign() {
        for (int i = 0; i < 5; i++) {
            if (gameBoard[i][0] == 0 && gameBoard[i][1] == 0 && gameBoard[i][2] == 0 && gameBoard[i][3] == 0 && gameBoard[i][4] == 0 || gameBoard[0][i] == 0 && gameBoard[1][i] == 0 && gameBoard[2][i] == 0 && gameBoard[3][i] == 0 && gameBoard[4][i] == 0) {
                return true;
            }
            if (gameBoard[0][0] == 0 && gameBoard[1][1] == 0  && gameBoard[3][3] == 0 && gameBoard[4][4] == 0 || gameBoard[0][4] == 0 && gameBoard[1][3] == 0 && gameBoard[3][1] == 0 && gameBoard[4][0] == 0) {
                return true;
            }
        }
        return false;
    }
    public BingoGameBoard() {
        this.gameBoard = createBoardAndDecideName();
    }
}
