package silver_lesson_12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Silver33 {
    static Map<String, String> map = new HashMap<>();
    static List<String> keys = List.of("A", "B", "C");
    static String[] values = {"1", "2", "3"};
    static {
        for (var i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values[i]);
        }
    }
    public static void main(String[] str) {
//        keys.clear();
        values = new String[0];
        System.out.println(map.size() + "," + keys.size() + "," + values.length);
    }
}
