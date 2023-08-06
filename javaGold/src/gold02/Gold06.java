package gold02;

import java.util.function.Predicate;

public class Gold06 {
    public static void main(String[] args) {
        Predicate<String> p1 = String::isEmpty;
        System.out.println(p1.test(""));
    }
}
