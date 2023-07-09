package silver_lesson_07;

class A20 {
    public A20() {
        System.out.println("A");
    }
}

class B20 extends A20 {
    public B20() {
        System.out.println("B");
    }
}
public class Silver07_20 {
    public static void main(String[] args) {
        A20 a = new B20();
        B20 b = new B20();
    }
}
