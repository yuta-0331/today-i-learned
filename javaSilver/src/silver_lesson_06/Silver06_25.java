package silver_lesson_06;

class Sample25 {
    public Sample25() {
        this("B");
        System.out.println("A");
    }
    public Sample25(String str) {
        System.out.println(str);
    }
}
public class Silver06_25 {
    public static void main(String[] args) {
        Sample25 s = new Sample25();
    }
}