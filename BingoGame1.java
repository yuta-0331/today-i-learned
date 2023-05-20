/*  授業で習った範囲で（二次元配列を用いずに）ビンゴゲームを作成する。
    ただし、配列処理が使えず冗長になるので、処理のメソッド切り出しは可とする。*/
public class BingoGame1 {
    //各列の番号を格納する配列
    public static int[] bColumnNumbers = new int[5];
    public static int[] iColumnNumbers = new int[5];
    public static int[] nColumnNumbers = new int[5];
    public static int[] gColumnNumbers = new int[5];
    public static int[] oColumnNumbers = new int[5];
    //各行の番号を格納する配列
    public static int[] firstLineNumbers = new int[5];
    public static int[] secondLineNumbers = new int[5];
    public static int[] thirdLineNumbers = new int[5];
    public static int[] fourthLineNumbers = new int[5];
    public static int[] fifthLineNumbers = new int[5];
    //当たり番号を格納する配列
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

    //横の行配列を作成するメソッド
    public static void createLine(int[] args, int num) {
        args[0] = bColumnNumbers[num];
        args[1] = iColumnNumbers[num];
        args[2] = nColumnNumbers[num]; 
        args[3] = gColumnNumbers[num]; 
        args[4] = oColumnNumbers[num];
    }

    //盤面を一行出力するメソッド
    public static void printLine(int[] args) {
        for (int i = 0; i < 5; i++) {
            String temp;
            //一桁の時のインデント調整
            if (args[i] < 10) {
                temp = "| " + args[i] + " ";
            } else {
                temp = "| " + args[i];
            }
            if (i == 4) {
                temp = temp + "|";
            }
            //配列の要素が0の場合、■を出力する処理
            if (args[i] == 0 && i == 4) {
                System.out.print("| ■ |");
            } else if (args[i] == 0) {
                System.out.print("| ■ ");
            } else {
                System.out.print(temp);
            }
        }
        System.out.println();
    }
    //ゲーム盤面全体を出力するメソッド
    public static void printBoard() {
        System.out.println("| B | I | N | G | O |");
        printLine(firstLineNumbers);
        printLine(secondLineNumbers);
        printLine(thirdLineNumbers);
        printLine(fourthLineNumbers);
        printLine(fifthLineNumbers);
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
        for (int i = 0; i < 5; i++) {
            if (args[i] == num) {
                args[i] = 0;
                System.out.println("hit!");
                break;
            } 
            System.out.println("hitなし");
        }
    }
    //抽選後の盤面チェックを行うメソッド
    public static void checkBoard(int num) { 
        if (num < 16) {
            checkHitNumber(num, firstLineNumbers);
        } else if (num < 31) {
            checkHitNumber(num, secondLineNumbers);
        } else if (num < 46) {
            checkHitNumber(num, thirdLineNumbers);
        } else if (num < 61) {
            checkHitNumber(num, fourthLineNumbers);
        } else {
            checkHitNumber(num, fifthLineNumbers);
        }
    }


    public static void main(String[] args) {
        
        //縦の列配列を作成
        createColumn(bColumnNumbers, 0);
        createColumn(iColumnNumbers, 15);
        createColumn(nColumnNumbers, 30);
        createColumn(gColumnNumbers, 45);
        createColumn(oColumnNumbers, 60);

        //縦の列配列を横の行配列に変換して扱いやすくする
        createLine(firstLineNumbers, 0);
        createLine(secondLineNumbers, 1);
        createLine(thirdLineNumbers, 2);
        createLine(fourthLineNumbers, 3);
        createLine(fifthLineNumbers, 4);

        //ビンゴ画面表示
        thirdLineNumbers[2] = 0;
        printBoard();

        boolean isClear = false;
        int count = 0;
        while (!isClear) {
            //enterが押されたら抽選開始
            String emptyString = MyConsole.readLine();
            int hitNum = chooseHitNumber(count);
            checkBoard(hitNum);
            printBoard();



            for(int i = 0; i < 75; i++ )
            System.out.print(
                hitNumbers[i] != 0 ? hitNumbers[i] + " " : ""
            );

        }
        //hitした番号を0に置き換える
        
        //出力時、0は■と置き換える
        
    }
}
