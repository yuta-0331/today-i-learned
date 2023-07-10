package silver_lesson_08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Silver08_05 {
    public static void main(String[] args) {
        List<Sample5> list = Arrays.asList(
                new Sample5(10), new Sample5(20), new Sample5(30)
        );
        Predicate<Sample5> x = s -> list.contains(s);
        if (x.test(new Sample5(20))) {
            System.out.println("ok");
        }
    }
}

class Sample5 {
    private int num;
    public Sample5(int num) {
        this.num = num;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Sample5 == false) {
            return false;
        }
        if (this.num == ((Sample5) obj).num) {
            return true;
        }
        return false;
    }
}