package silver_lesson_06;

class Sample13 {
    public int method(int a, int b) {
        return a + b;
    }
}
public class Silver06_13 {
    public static void main(String[] args) {
        Sample13 s = new Sample13();
        int result = s.method(2, 3);
        System.out.println(result);
    }
}
