package silver_lesson_09;

import java.time.LocalDate;

public class Silver09_05 {
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(2015, 1, 1);
        LocalDate b = LocalDate.parse("2015-01-01");
        System.out.println(a.equals(b));
    }
}
