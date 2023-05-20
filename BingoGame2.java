/*  授業で習った範囲で（二次元配列を用いずに）ビンゴゲームを作成する。
    ただし、配列処理が使えず冗長になるので、処理のメソッド切り出しは可とする。*/
public class BingoGame2 {
    //各列の番号を格納する配列
    public static int[] bColumnNumbers = new int[5];
    public static int[] iColumnNumbers = new int[5];
    public static int[] nColumnNumbers = new int[5];
    public static int[] gColumnNumbers = new int[5];
    public static int[] oColumnNumbers = new int[5];
    //5*5の盤面を格納する配列
    public static int[] boardNumbers = new int[25];
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

    //盤面の行配列を作成するメソッド
    public static int[] createBoard(int[] args) {
        for (int i = 0, j = 0; i < 25; i++) {
            if ((i + 1) % 5 == 1) {
                args[i] = bColumnNumbers[j];
            } else if ((i + 1) % 5 == 2) {
                args[i] = iColumnNumbers[j];
            } else if ((i + 1) % 5 == 3) {
                args[i] = nColumnNumbers[j];
            } else if ((i + 1) % 5 == 4) {
                args[i] = gColumnNumbers[j];
            } else {
                args[i] = oColumnNumbers[j];
                j++;
            }
        }
        return boardNumbers;
    }

    //盤面を出力するメソッド
    public static void printBoard(int[] args) {
        System.out.println("---------------------");
        System.out.println("| B | I | N | G | O |");
        System.out.println("---------------------");

        for (int i = 0; i < 25; i++) {
            String temp;
            //一桁の数値の場合のインデント調整
            if (args[i] < 10) {
                temp = "| " + args[i] + " ";
            } else {
                temp = "| " + args[i];
            }
            if (i % 5 == 4) {
                temp = temp + "|";
            }
            //配列の要素が0の場合、■を出力する処理
            if (args[i] == 0 && i % 5 == 4) {
                System.out.print("| ■ |");
            } else if (args[i] == 0) {
                System.out.print("| ■ ");
            } else {
                System.out.print(temp);
            }
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println("---------------------");
    }

    //当たり番号を(重複しないように)抽選するメソッド
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
    public static void checkHitNumber(int num, int[] args) {
        boolean hitFlag = false;
        for (int i = 0; i < 25; i++) {
            if (args[i] == num) {
                args[i] = 0;
                hitFlag = true;
                break;
            } 
        }
        if (hitFlag) {
            System.out.println("hit!");
        } else {
            System.out.println("hitなし");
        }
    }

    /////////////////////////////////////////////////////////
    //以下、クリア条件を満たしていないかチェック////////////////////
    //引数で与えられた盤面のnum行目が揃っているかをチェックするメソッド
    public static boolean checkAlignLine(int[] args ,int num) {
        if (args[5 * (num - 1)] == 0 && args[5 * (num - 1) + 1] == 0 && args[5 * (num - 1) + 2] == 0 && args[5 * (num - 1) + 3] == 0 && args[5 * (num - 1) + 4] == 0) {
            return true;
        } else {
            return false;
        }
    }
    //引数で与えられた盤面のnum列目が揃っているかをチェックするメソッド
    public static boolean checkAlignColumn(int[] args, int num) {
        if (args[num - 1] == 0 && args[(num + 4)] == 0 && args[(num + 9)] == 0 && args[(num + 14)] == 0 && args[(num + 19)] == 0) {
            return true;
        } else {
            return false;
        }
    }
    //引数で与えられた盤面の斜めが揃っていないかチェックするメソッド
    public static boolean checkAlignDiagonal(int[] args) {
        if (args[0] == 0 && args[6] == 0 && args[18] == 0 && args[24] == 0 || args[4] == 0 && args[8] == 0 && args[16] == 0 && args[20] == 0
        ) {
            return true;
        } else {
            return false;
        }
    }
    //盤面がゲーム終了条件を満たしていないかチェックするメソッド
    public static boolean checkBoard(int[] args) {
        boolean clearFlag = false;
        if (
            checkAlignColumn(args, 1) || checkAlignColumn(args, 2) || checkAlignColumn(args, 3) || checkAlignColumn(args, 4) || checkAlignColumn(args, 5) ||
            checkAlignLine(args, 1) || checkAlignLine(args, 2) || checkAlignLine(args, 3) || checkAlignLine(args, 4) || checkAlignLine(args, 5) ||
            checkAlignDiagonal(args) 
        ) {
            clearFlag = true;
        }
        return clearFlag;
    }
    //////////////////////////////////////////////////////////
    //以上クリア条件チェック//////////////////////////////////////
    //////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //縦の列配列を作成
        createColumn(bColumnNumbers, 0);
        createColumn(iColumnNumbers, 15);
        createColumn(nColumnNumbers, 30);
        createColumn(gColumnNumbers, 45);
        createColumn(oColumnNumbers, 60);

        //縦の列配列を横の行配列に変換して扱いやすくする
        createBoard(boardNumbers);

        //ビンゴ画面表示
        boardNumbers[12] = 0;
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
            if (checkBoard(boardNumbers)) {
                break;
            }
        }
        System.out.println(count + "回目でゲームが終了しました");
    }
}
