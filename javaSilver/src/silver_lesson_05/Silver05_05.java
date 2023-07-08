package silver_lesson_05;

class Item {
    String name;
    int price = 100;
}
public class Silver05_05 {
    public static void main(String[] args) {
        Item[] items = new Item[3];
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            total += items[i].price;
        }
        System.out.println(total);
    }
}
