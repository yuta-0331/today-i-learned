package silver_lesson_08;

import java.util.function.Function;

public class Silver08_07 {
    public static void main(String[] args) {
        Function<String, Integer> func = (str) -> {
            return Integer.parseInt(str);
        };
        System.out.println(func.apply("100") * 2);
    }
}
