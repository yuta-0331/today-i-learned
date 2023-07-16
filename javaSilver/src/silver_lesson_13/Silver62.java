package silver_lesson_13;

public class Silver62 {
    public static void main(String[] args) {
        Test62 a = new Test62();
        Test62 b = new Test62();

        a.sample();
        b.sample();
        System.out.println(a.value + ", " + b.value);
    }
}

class Test62 {
    static int value = 0;
    int count = 0;
    public void sample() {
        while (count < 5) {
            count++;
            value++;
        }
    }
}