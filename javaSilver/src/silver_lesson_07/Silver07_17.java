package silver_lesson_07;

class A17 {
    void hello() {
        System.out.println("A");
    }
}

class B17 extends A17 {
    void hello() {
        System.out.println("B");
    }
}
public class Silver07_17 {
    public static void main(String[] args) {
        A17 a = new A17();
        B17 b = (B17) a;
        b.hello();
    }
}
