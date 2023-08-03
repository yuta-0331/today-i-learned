package gold01;

interface A12 {
    default void test() {
        System.out.println("A");
    }
}
class B12 {
    public void test() {
        System.out.println("B");
    }
}
class C12 extends B12 implements A12 {}
public class Gold12 {
    public static void main(String[] args) {
        A12 a = new C12();
        a.test();
    }
}
