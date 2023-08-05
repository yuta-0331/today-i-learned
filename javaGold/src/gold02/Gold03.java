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

    public static class Builder {
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
// インスタンス生成時に、どのフィールドにどの値をセットするのかわかりやすい
class Sample03 {
    public static void main(String[] args) {
        Item03 item = new Item03.Builder(100)
                .setName("orange")
                .setPrice(120)
                .build();
        System.out.println(item);

    }
}

class Item03kai {
    private int id;
    private String name;
    private int price;

    private Item03kai(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    public static class Builder {
        private int id;
        public String name;
        public int price;

        public Builder(int id) {
            this.id = id;
        }
        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }
        public Item03kai build() {
            return new Item03kai(this);
        }
    }
}
class Sample03kai {
    public static void main(String[] args) {
        Item03kai item = new Item03kai.Builder(100)
                .with(b -> {
                    b.name = "orange";
                    b.price = 120;
                }).build();
        System.out.println(item);
    }
}