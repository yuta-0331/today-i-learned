package silver_lesson_07;
abstract class A8 {
    int a = 8;
    abstract void method();
}

public class Silver07_08 extends A8 {
    void method() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Silver07_08().method();
    }

}
