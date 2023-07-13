package silver_lesson_09;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Silver09_08 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add("A");
        list.add(10);
        list.add('B');
        for (Object obj : list) {
            System.out.print(obj);
        }
    }
}
