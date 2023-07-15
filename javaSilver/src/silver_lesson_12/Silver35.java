package silver_lesson_12;

class A35 {
    private void print() {
        System.out.println("A");
    }
    public void a() {
        print();
    }
}
public class Silver35 extends A35 {
    private void print() {
        System.out.println("B");
    }
    public void b() {
        print();
    }

    public static void main(String[] args) {
        Silver35 b = new Silver35();
        b.a();
        b.b();
    }
}
