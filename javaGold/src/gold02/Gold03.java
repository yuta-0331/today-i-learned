package gold02;

import java.util.function.Consumer;

public class Gold03 {
    public static void main(String[] args) {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("Hello, Lambda");
    }
}
class Item03 {
    private int id;
    private String name;
    private int price;

    private Item03(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    static class Builder {
        private int id;
        private String name;
        private int price;
        public Builder(int id) {
            this.id = id;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }
        public Item03 build() {
            return new Item03(this);
        }
    }
}

class Sample03 {
    public static void main(String[] args) {
        Item03 item = new Item03.Builder(100)
                .setName("orange")
                .setPrice(120)
                .build();
        System.out.println(item);
    }
}