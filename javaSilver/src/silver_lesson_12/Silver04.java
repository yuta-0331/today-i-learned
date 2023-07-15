package silver_lesson_12;

import java.util.function.Supplier;

public class Silver04 {
    void sample() {
        final int i = 0;
        Supplier<Integer> foo = () -> i;
        System.out.println(foo.get());
    }
}
