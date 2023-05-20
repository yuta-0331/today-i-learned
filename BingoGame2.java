public class BingoGame2 {
    //5*5の盤面を格納する配列
    public static int[][] boardNumbers = new int[5][5];
    //当たり番号を格納する配列（*todo:75の数値は最適化すること）
    public static int[] hitNumbers = new int[75];

    //縦の列配列を作成(重複なく番号を格納)するメソッド
    public static void createColumn(int[] args, int num) {
        int index = 0;
        while (index < 5) {
            int tmp = (int) (Math.random() * 15) + 1 + num;
            boolean continueFlag = true;
            for (int i = 0; i < 5; i++) {
                if (args[i] == tmp) {
                    continueFlag = false;
                }
            }
            if (!continueFlag) {
                continue;
            } else {
                args[index] = tmp;
                index++;
            }
        }
    }

    //盤面の行配列を引数で渡された変数に格納するメソッド
    public static int[][] createBoard(int[][] args) {
        //縦の列配列を作成
        int[][] columnNumbers = new int [5][5];
        for (int i = 0, j = 0; i < 5; i++, j += 15) {
            createColumn(columnNumbers[i], j);
        }
        
        //縦の列配列を盤面配列に格納
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                args[i][j] = columnNumbers[j][i];
            }
        }
        return boardNumbers;
    }

    //盤面を出力するメソッド
    public static void printBoard(int[][] args) {
        System.out.println("---------------------");
        System.out.println("| B | I | N | G | O |");
        System.out.println("---------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String temp;
                if (args[i][j] != 0) {
                    //一桁の数値の場合のインデントを調整
                    if (args[i][j] < 10) {
                        temp = "| " + args[i][j] + " ";
                    } else {
                        temp = "| " + args[i][j];
                    }
                    if (j == 4) {
                        temp = temp + "|";
                    }
                    System.out.print(temp);
                } else {
                    //配列の要素が0の場合、■を出力する処理
                    if (j == 4) {
                        System.out.print("| ■ |");
                    } else {
                        System.out.print("| ■ ");
                    }
                }
                if (j == 4) {
                    System.out.println();
                }
            }
        }
        System.out.println("---------------------");
    }

    //当たり番号を(重複しないように)抽選し、配列に格納するメソッド
    public static int chooseHitNumber(int index) {
        while (true) {
            int tmp = (int) (Math.random() * 75) + 1;
            boolean continueFlag = true;
            for (int i = 0; i < 75; i++) {
                if (hitNumbers[i] == tmp) {
                    continueFlag = false;
                }
            }
            if (!continueFlag) {
                continue;
            } else {
                hitNumbers[index] = tmp;
                break;
            }
        }
        return hitNumbers[index];
    }

    //引数で与えた配列が要素にnumを持っていてたら、値を0に置換するメソッド
    public static void checkHitNumber(int num, int[][] args) {
        boolean hitFlag = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (args[i][j] == num) {
                    args[i][j] = 0;
                    hitFlag = true;
                    break;
                }
            }
        }
        if (hitFlag) {
            System.out.println("Hit!");
        } else {
            System.out.println("Deviate");
        }
    }
    //引数に渡した盤面配列がクリア条件を満たしていないかチェック
    public static boolean checkAlign(int[][] args) {
        boolean alignFlag = false;
        for (int i = 0; i < 5; i++) {
            if (
                args[i][0] == 0 && args[i][1] == 0 && args[i][2] == 0 && args[i][3] == 0 && args[i][4] == 0 ||
                args[1][i] == 0 && args[2][i] == 0 && args[3][i] == 0 && args[4][i] == 0 && args[5][i] == 0 ||
                args[0][0] == 0 && args[1][1] == 0  && args[3][3] == 0 && args[4][4] == 0 ||
                args[0][4] == 0 && args[1][3] == 0 && args[3][1] == 0 && args[4][0] == 0
                
                ) {
                    alignFlag = true;
                }
            }
        return alignFlag;
    }
    
    public static void main(String[] args) {
        //盤面の配列を作成
        createBoard(boardNumbers);

        //ビンゴ画面表示
        boardNumbers[2][2] = 0;
        printBoard(boardNumbers);

        //ゲーム開始
        int count = 0;
        while (true) {
            //enterが押されたら抽選スタート
            MyConsole.readLine();
            int hitNumber = chooseHitNumber(count);
            System.out.println("抽選番号:" + hitNumber);
            checkHitNumber(hitNumber, boardNumbers);
            printBoard(boardNumbers);
            count++;
            //ゲーム終了条件を満たしたらbreak
            if (count < 4) continue;
            if (checkAlign(boardNumbers)) {
                break;
            }
        }
        System.out.println(count + "回目でゲームが終了しました");
    }
}
