package silver_lesson_13;

class Sample25 {
    public String value;
    public Sample25(String value) {
        this.value = value;
    }
}
public class Silver25 {

    public static void main(String[] args) {
        Sample25 s = new Sample25("Hello Java");
        System.out.println(s.value);
    }
}
