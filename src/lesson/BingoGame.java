package lesson;

class BingoGameBoard {
	public int[][] gameBoard;
	
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
	public BingoGameBoard(int[][] args) {
        this.gameBoard = createBoard(args);
	}
}
public class BingoGame {
    //引数に盤面の配列を渡すと、盤面を出力するメソッド
    public static void printBoard(int[][] boardArray, String name) {
    	System.out.println("player: " + name);
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
    public static void checkHitNumber(int hitNum, int[][] boardArray, String name) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (boardArray[i][j] == hitNum) {
                    boardArray[i][j] = 0;
                    System.out.println(name + ": Hit!");
                    return;
                }
            }
        }
        System.out.println(name + ": Deviate");
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
        //2つのボードを作成
        int[][] board_01 = new int[5][5];
        new BingoGameBoard(board_01);
        board_01[2][2] = 0;
        int[][] board_02 = new int[5][5];
        new BingoGameBoard(board_02);
        board_02[2][2] = 0;
        //プレイヤー名を入力
        System.out.println("player1の名前を入力してください");
        String inputName_01 = MyConsole.readLine();
        System.out.println("player2の名前を入力してください");
        String inputName_02 = MyConsole.readLine();
        
        int[] hitNumbers = new int[75];
        for (int i = 0; i < 75; i++) {
            printBoard(board_01, inputName_01);
            printBoard(board_02, inputName_02);
            MyConsole.readLine();
            BingoGameBoard.generateArrayWithUniqueNumber(i, hitNumbers, 75, 1);
            System.out.println("抽選番号:" + hitNumbers[i]);
            checkHitNumber(hitNumbers[i], board_01, inputName_01);
            checkHitNumber(hitNumbers[i], board_02, inputName_02);
            if (i >= 3 && checkAlign(board_01) && checkAlign(board_02)) {
                printBoard(board_01, inputName_01);
                printBoard(board_02, inputName_02);
                System.out.println(i + 1 + "回目でゲームが終了しました。引き分けです。");
                break;
            } else if (i >= 3 && checkAlign(board_01)) {
            	printBoard(board_01, inputName_01);
                System.out.println(i + 1 + "回目でゲームが終了しました。" + inputName_01 + "の勝利です。");
                break;
            } else if (i >= 3 && checkAlign(board_02)) {
            	printBoard(board_02, inputName_02);
                System.out.println(i + 1 + "回目でゲームが終了しました。" + inputName_02 + "の勝利です。");
                break;
            }
        }
    }
}
