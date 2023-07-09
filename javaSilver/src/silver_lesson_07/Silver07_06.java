package silver_lesson_07;
interface A6 {
    default void sample() {
        System.out.println("hello");
    }
}
interface B6 extends A6 {

}
class C6 implements B6 {
    @Override
    public void sample() {

        System.out.println("Java");
    }
}

public class Silver07_06 {
    public static void main(String[] args) {
        A6 a = new C6();
        a.sample();
    }
}
