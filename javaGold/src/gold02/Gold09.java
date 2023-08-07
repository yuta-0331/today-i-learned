package gold02;

import java.util.function.Function;

public class Gold09 {
    public static void main(String[] args) {
        Function<String, Integer> f = x -> x.length();
        System.out.println(f.apply("sample"));
    }
}
