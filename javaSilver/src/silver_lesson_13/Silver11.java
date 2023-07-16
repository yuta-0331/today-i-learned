package silver_lesson_13;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Silver11 {
    private static int num;
    static {
        num = 10;
    }
    static {
        num = 20;
    }
    static void test(int num) {
        num = num * num;
    }

    public static void main(String[] args) {
        test(num);
        System.out.println(num);
    }
}
