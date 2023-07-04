package silver_lesson_03;

class Sample1 {
    private int num;
    public Sample1(int num) {
        this.num = num;
    }
}

public class Silver03_08 {
    public static void main(String[] args) {
        Sample1 s1 = new Sample1(10);
        Sample1 s2 = s1;
        s1 = new Sample1(10);
        System.out.println(s1 == s2);
    }
}
