package silver_lesson_07;
interface A5 {
    String toString();
}

class B5 implements A5 {
    @Override
    public String toString() {
        return "B";
    }

}
public class Silver07_05 extends Parent1 {
    public static void main(String[] args) {
        A5 a = new B5();
        System.out.println(a);
    }
}
