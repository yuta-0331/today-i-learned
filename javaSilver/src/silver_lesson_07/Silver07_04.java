package silver_lesson_07;

class Parent1 {
    String name;
}
public class Silver07_01 extends Parent1 {
    Silver07_01() {
        name = "java";
    }
    void hello() {
        System.out.println("hello" + name);
    }
}
