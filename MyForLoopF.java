
class InvalidNumberException extends Exception {
    InvalidNumberException(String msg) {
        super(msg);
    }
}

public class MyForLoopF {
    public static void main(String[] arg) {
        
        int width, height;
        System.out.println("よこ");
        try {
            width = Integer.parseInt(MyConsole.readLine());
            if (width < 0) throw new InvalidNumberException("正の整数で入力");
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            return;
        } 

        System.out.println("たて");
        try {
            height = Integer.parseInt(MyConsole.readLine());

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
    }
}
