package silver_lesson_13;

class Sample33 {
    public void test(Object[] val) {
        System.out.println("A");
    }
    public void test(long[] val) {
        System.out.println("B");
    }
    public void test(Object val) {
        System.out.println("C");
    }
}
public class Silver33 {
    public static void main(String[] args) {
        new Sample33().test(new int[3]);
    }
}
