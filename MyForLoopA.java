import java.util.Scanner;

public class MyForLoopA {

    public static void main(String[] args) {

        System.out.println("何回誉めますか？");
        int num;
        try {
            Scanner inputNumScanner = new Scanner(System.in);
            num = inputNumScanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            return;
        }

        for (int i = 0; i < num; i++) {
            String msg;
            int j = (int) (Math.random() * 10) + 1;
            if (j % 2 == 0) {
                msg = "あなたは幸せになる";
            } else {
                msg = "よく頑張ったね";
            }
            System.out.println(msg);
        }    
    }
}