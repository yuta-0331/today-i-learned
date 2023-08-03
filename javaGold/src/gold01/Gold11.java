package gold01;

interface A11 {
    default void test() {
        System.out.println("A");
    }
}
interface B11 {
    default void test() {
        System.out.println("B");
    }
}
interface C11 extends B11 {}
interface D11 extends C11 {}
public class Gold11 implements A11, D11 {
    @Override
    public void test() {
        A11.super.test();
    }
}
