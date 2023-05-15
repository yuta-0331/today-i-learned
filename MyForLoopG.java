public class MyForLoopG {
    public static void main(String[] args) {
        System.out.println("高さは？");
        int height = Integer.parseInt(MyConsole.readLine());

        for (int i = 1; i <= height; i++) {
            //height - i 個空白を重ねる
            for (int k = 0; k < height - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
