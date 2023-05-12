import java.util.Scanner;

class InvalidNumberException extends Exception {
    InvalidNumberException(String msg) {
        super(msg);
    }
}

public class MyForLoopF {
    public static void main(String[] arg) {
        
        int width, height;
        System.out.println("よこ");
        Scanner widthScanner = new Scanner(System.in);
        try {
            width = widthScanner.nextInt();
            if (width < 0) throw new InvalidNumberException("正の整数で入力");
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            return;
        } 

        System.out.println("たて");
        Scanner heightScanner = new Scanner(System.in);
        try {
            height = heightScanner.nextInt();

            if (height < 0) throw new InvalidNumberException("正の整数で入力");
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            return;
        } 

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("□");
            }
            System.out.println("");
        }

        widthScanner.close();
        heightScanner.close();
    }
}
