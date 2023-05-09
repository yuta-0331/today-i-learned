import java.util.InputMismatchException;
import java.util.Scanner;

public class MyAndOrOperator {
    public static void main(String[] args) {
        
        System.out.println("月を入力してください（1〜12）");
        Scanner inputMonthScanner = new Scanner(System.in);
        int inputMonth;
        try {
            inputMonth = inputMonthScanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e + " => 1〜12の数値で入力してください");
            inputMonthScanner.close();
            return;
        }
        if (inputMonth < 1 || inputMonth > 12) {
            System.out.println("1〜12で入力してください");
            inputMonthScanner.close();
            return;
        }

        String season, msg;
        if (inputMonth == 12 || inputMonth < 3) {
            season = "冬";
            msg = "寒いですね";
        } else if (inputMonth < 6) {
            season = "春";
            msg = "気持ちのいい陽気ですね";
        } else if (inputMonth < 9) {
            season = "夏";
            msg = "暑いですね";
        } else {
            season = "秋";
            msg = "涼しいですね";
        }

        System.out.println(season + msg);

        inputMonthScanner.close();
    }
}
