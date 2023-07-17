package silver_lesson_ex;

interface A {
    default void sample() {
        System.out.println("A");
    }
}

interface B extends A {
    @Override
    default void sample() {
        System.out.println("B");
    }
}
public class Silver07_01 implements B {
    public void sample() {
        B.super.sample();
        System.out.println("B");
    }
    public static void main(String[] args) {
        A a = new Silver07_01();
    }

}
