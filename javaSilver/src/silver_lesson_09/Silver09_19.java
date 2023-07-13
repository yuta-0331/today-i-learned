package silver_lesson_09;

import java.util.HashMap;
import java.util.Map;

class Item19 {
    private int id;
    private String name;
    public Item19(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Silver09_19 {
    public static void main(String[] args) {
        Map<Integer, Item19> map = new HashMap<Integer, Item19>();
        map.put(1, new Item19(1, "A"));
        map.put(2, new Item19(2, "B"));
        map.put(3, new Item19(3, "C"));
        map.put(1, new Item19(1, "A"));
        map.put(null, new Item19(0, "default"));

        System.out.println(map.size());
    }
}
