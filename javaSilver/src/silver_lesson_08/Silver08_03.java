package silver_lesson_08;

import java.util.function.Function;

public class Silver08_03 {
    public static void main(String[] args) {
        String val = "A";
        Function f = System.out::println;
        f.test("B");
    }
    interface Function {
        void test(String val);
    }

}
