package lesson;

public class BingoGame {
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
            if (continueFlag) {
                continue;
            } else {
                array[index] = tmp;
                break;
            }
        }
    }

    //盤面の行配列を引数に格納するメソッド
    public static int[][] createBoard(int[][] boardArray) {
        int[][] columnNumbers = new int [5][5];
        for (int i = 0, j = 1; i < 5; i++, j += 15) {
            for (int k = 0; k < 5; k++) {
                generateArrayWithUniqueNumber(k, columnNumbers[i], 15, j);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boardArray[i][j] = columnNumbers[j][i];
            }
        }
        return boardArray;
    }

    //引数に盤面の配列を渡すと、盤面を出力するメソッド
    public static void printBoard(int[][] boardArray) {
        System.out.println("---------------------");
        System.out.println("| B | I | N | G | O |");
        System.out.println("---------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String temp;
                if (boardArray[i][j] > 0) {
                    temp = boardArray[i][j] < 10 ? ("| " + boardArray[i][j] + " ") : ("| " + boardArray[i][j]);
                } else {
                    temp = "| ■ ";
                }
                System.out.print(j == 4 ? temp + "|" + "\n" : temp);
            }
        }
        System.out.println("---------------------");
    }

    //引数の要素にnumを持っていてたら、値を0に置換するメソッド
    public static void checkHitNumber(int hitNum, int[][] boardArray) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (boardArray[i][j] == hitNum) {
                    boardArray[i][j] = 0;
                    System.out.println("Hit!");
                    return;
                }
            }
        }
        System.out.println("Deviate");
    }
    
    //引数に渡した盤面の配列がクリア条件を満たしていないかチェック
    public static boolean checkAlign(int[][] boardArray) {
        for (int i = 0; i < 5; i++) {
            if (
                boardArray[i][0] == 0 && boardArray[i][1] == 0 && boardArray[i][2] == 0 && boardArray[i][3] == 0 && boardArray[i][4] == 0 ||
                boardArray[0][i] == 0 && boardArray[1][i] == 0 && boardArray[2][i] == 0 && boardArray[3][i] == 0 && boardArray[4][i] == 0
            ) {
                    return true;
            }
            if (
                boardArray[0][0] == 0 && boardArray[1][1] == 0  && boardArray[3][3] == 0 && boardArray[4][4] == 0 ||
                boardArray[0][4] == 0 && boardArray[1][3] == 0 && boardArray[3][1] == 0 && boardArray[4][0] == 0
            ) {
                    return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] boardNumbers = new int[5][5];
        createBoard(boardNumbers);
        boardNumbers[2][2] = 0;

        int[] hitNumbers = new int[75];
        for (int i = 1; i <= 75; i++) {
            printBoard(boardNumbers);
            MyConsole.readLine();
            generateArrayWithUniqueNumber(i - 1, hitNumbers, 75, 1);
            System.out.println("抽選番号:" + hitNumbers[i - 1]);
            checkHitNumber(hitNumbers[i - 1], boardNumbers);
            if (i >= 4 && checkAlign(boardNumbers)) {
                printBoard(boardNumbers);
                System.out.println(i + "回目でゲームが終了しました");
                break;
            }
        }
    }
}
