package silver_lesson_12;

class Sample44 {
    String name;
    int num;
    public Sample44(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

class SubSample44 extends Sample44 {
    int price;
//    public SubSample44(int price) {
//        this.price = price;
//    }
    public SubSample44(String name, int num, int price) {
        super(name, num);
//        this(price);
    }
}
public class Silver44 {
    public static void main(String[] args) {

    }
}
