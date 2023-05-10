import java.util.Scanner;

class InvalidNumberException extends Exception {
    InvalidNumberException(String msg) {
        super(msg);
    }
}

public class MyForLoopA {

    public static void main(String[] args) {

        System.out.println("何回誉めますか？");
        Scanner inputNumScanner = new Scanner(System.in);
        int num;
        try {
            num = inputNumScanner.nextInt();
            if (num <= 0) {
                throw new InvalidNumberException("正の整数で入力してください");
            }
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            return;
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            inputNumScanner.close();
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