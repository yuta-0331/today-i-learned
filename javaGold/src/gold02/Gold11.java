package gold02;

import java.util.function.BiFunction;

public class Gold11 {
    public static void main(String[] args) {
        BiFunction<String, String, String> b = (str, addStr) -> str.concat(addStr);
        String result = b.apply("Hello", "Lambda");
        System.out.print(result);
    }
}
