package silver_lesson_07;
class A12 {
    String val = "A";
    void print() {
        System.out.println(val);
    }
}
class B12 extends A12 {
    String val = "B";
}

public class Silver07_12 {
    public static void main(String[] args) {
        A12 a = new A12();
        A12 b = new B12();
        System.out.println(a.val);
        System.out.println(b.val);
        a.print();
        b.print();
    }
}
