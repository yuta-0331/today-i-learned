package gold01;

import java.util.Comparator;

public class Gold03 {
    public static class Inner {
        Inner inner = new Gold03.Inner(); //C
    }
}

class Item implements Comparable<Item> {
    private String name;
    private int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public int compareTo(Item target) {
        return name.compareTo(target.name);
    }

    public static class PriceComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            if (a.price < b.price) {
                return -1;
            }
            if (b.price < a.price) {
                return 1;
            }
            return 0;
        }
    }
}