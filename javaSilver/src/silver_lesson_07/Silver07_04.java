package silver_lesson_07;
interface A4 {
     default void sample() {
        System.out.println("sample");
    }
}
class B4 implements A4 {

}
public class Silver07_04 extends Parent1 {
    public static void main(String[] args) {
        A4 a = new B4();
        a.sample();
    }
}
