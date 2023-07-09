package silver_lesson_06;

public class Silver06_17 {
    public static void main(String[] args) {
        Silver06_17 m = new Silver06_17();
        System.out.println(m.calc(2.0, 3));
    }
    private double calc(double a, int b) {
        return (a + b) / 2;
    }

    private double calc(int a, double b) {
        return (a + b) / 2;
    }
}