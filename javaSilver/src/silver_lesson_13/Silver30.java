package silver_lesson_13;

interface Function30 {
    void process();
}
class Sample30 implements Function30 {
    public void process() {
        System.out.println("A");
    }
}
public class Silver30 extends Sample30 {

    public void process() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        Sample30 s = new Silver30();
        Sample30 s2 = new Sample30();
        test(s);
        test(s2);
    }
    public static void test(Function30 f) {
        f.process();
    }
}
