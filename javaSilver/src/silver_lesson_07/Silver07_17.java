package silver_lesson_07;

class A16 {}

class B16 extends A16 {
    void hello() {
        System.out.println("hello");
    }
}
public class Silver07_16 {
    public static void main(String[] args) {
        A16 a = new B16();
        B16 b = (B16) a;
        b.hello();
    }
}
