// *を出力して菱形、平行四辺形を作成するプログラム

public class MyForLoopH {
    public static void main(String[] args) {
        System.out.println("対角線の長さは？");
        int length = Integer.parseInt(MyConsole.readLine());
        //上下二つの三角形にわけ、上の三角形の高さをtopHeight, 
        //下の三角形の高さをbottomHeightとする
        int topHeight = (length + 1) / 2;
        int bottomHeight = length - topHeight;

        for (int i = 1; i <= length; i ++) {
            //上の三角形を出力
            if (i <= topHeight) {
                for (int j = 0; j < topHeight - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 0; j < ; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        //まず上の三角形を出力
        for (int i = 1; i <= topHeight; i++) {
            for (int j = 0; j < topHeight - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //次に下の逆三角形を出力
        for (int i = 1; i <= bottomHeight; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * topHeight - 1 - 2 * i; j++) {
                System.out.print("*"); 
            }
            System.out.println();
        }
    }
}
