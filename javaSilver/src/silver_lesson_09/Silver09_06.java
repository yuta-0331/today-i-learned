package silver_lesson_09;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Silver09_06 {
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(2019, 8, 19);
        LocalDate b = LocalDate.now();
        System.out.println(a.with(DayOfWeek.MONDAY));
        System.out.println(a.equals(b) + ", " + a.isBefore(b));
    }
}
