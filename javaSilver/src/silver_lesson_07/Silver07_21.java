package silver_lesson_07;

class Parent21 {
    public Parent21() {
        System.out.println("A");
    }
    public Parent21(String val) {
        this();
        System.out.println(val);
    }
}

class Child21 extends Parent21 {
    public Child21() {
        super("B");
        System.out.println("C");
    }
    public Child21(String val) {
        this();
        System.out.println(val);
    }
}
public class Silver07_21 {
    public static void main(String[] args) {
        new Child21("D");
    }
}
