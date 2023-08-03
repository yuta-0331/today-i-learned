package gold01;

interface A13 {
    default void test() {
        System.out.println("A");
    }
}
abstract class B13 {
    public void test() {
        System.out.println("B");
    }
}
public class Gold13 extends B13 implements A13{
    public static void main(String[] args) {
        new Gold13().test();
    }
}
