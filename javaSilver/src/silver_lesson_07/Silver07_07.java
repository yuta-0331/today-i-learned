package silver_lesson_07;
interface A7 {
    default void test() {
        System.out.println("A");
    }
}
interface B7 {
    default void test() {
        System.out.println("B");
    }
}

public class Silver07_07 implements A7, B7 {
    public void test() {
        A7.super.test();
    }
    public static void main(String[] args) {
        new Silver07_07().test();
    }
}
