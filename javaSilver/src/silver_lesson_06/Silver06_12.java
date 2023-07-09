package silver_lesson_06;

class Sample12 {
    float divide(int a, int b) {
        return (float) a / (float) b;
    }
}
public class Silver06_12 {
    public static void main(String[] args) {
        Sample12 s = new Sample12();
        double result = s.divide(10, 2);
        System.out.println(result);
    }
}
