public class ChristmasTree {
    public static void main(String[] args) {
        System.out.print("高さは？");
        int height = Integer.parseInt(MyConsole.readLine());
        int treeHeight = 2 * height + 1;

        for (int i = 1; i <= treeHeight; i++) {
            for (int j = 0; j < treeHeight - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j == treeHeight || j == 2 * (i - 1) - treeHeight) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
