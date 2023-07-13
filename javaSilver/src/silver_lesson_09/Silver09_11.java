package silver_lesson_09;

import java.util.ArrayList;

class Item11 {
    private String name;
    private int price;
    public Item11(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Item11) {
            Item11 tmp = (Item11) obj;
            if (tmp.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }
    public String getName() {
        return name;
    }
}
public class Silver09_11 {
    public static void main(String[] args) {
        ArrayList<Item11> list = new ArrayList<>();
        list.add(new Item11("A", 100));
        list.add(new Item11("B", 200));
        list.add(new Item11("C", 300));
        list.add(new Item11("A", 500));
        list.remove(new Item11("A", 500));

        for (Item11 item : list) {
            System.out.println(item.getName());
        }
    }
}
