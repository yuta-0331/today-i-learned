package silver_lesson_06;

class Sample22 {
    static int num;
    {
        num = 10;
    }
    public Sample22() {
        num = 100;
    }
}
public class Silver06_22 {
    public static void main(String[] args) {
        System.out.println(Sample22.num);
    }
}