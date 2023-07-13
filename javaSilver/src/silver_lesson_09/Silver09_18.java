package silver_lesson_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Silver09_18 {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        list.forEach(str -> System.out.println(str));
        list.forEach(System.out::println);
    }
}
