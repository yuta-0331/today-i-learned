package silver_lesson_04;

public class Silver04_05 {
    public static void main(String[] args) {
        int a = 1;
        for (int b = 2, total = 0; b <= 5; b++) {
            total = a * b;
        }
//        System.out.println(total);

        for (int i = 0; i == 0; i++) {
            System.out.println(i);
        }

//        for (int i = 0, j = 0; i < 3, j < 5; i++) {
//            System.out.println(i++);
//            j += i;
//        }

        for (int i = 0; i < 3; i++, period()) {
            System.out.print(i);
        }
    }

    private static void period() {
        System.out.print(",");
    }
}
