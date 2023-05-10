public class MyForLoopB {
    public static void main(String[] args) {

        for (int i = 1; i <= 30; i++) {
            System.out.println(i + (i % 3 == 0 ? " AHO" : ""));
        }
    }
}
