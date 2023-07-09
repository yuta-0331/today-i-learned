package silver_lesson_06;

class Sample29 {
    int num;
    public Sample29(int num) {
        this.num = num;
    }
}
public class Silver06_29 {
    public static void main(String[] args) {
        Sample29 s = new Sample29(10);
        modify(s.num);
        System.out.println(s.num);
    }
    private static void modify(int num) {
        num *= 2;
    }
}