package silver_lesson_09;

import java.util.ArrayList;

public class Silver09_10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.set(0, "B");
        list.add("C");
        list.set(1, "D");
        for (String str : list) {
            System.out.print(str);
        }
    }
}
