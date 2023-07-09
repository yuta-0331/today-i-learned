package silver_lesson_06;

class Sample5 {
    static int num = 0;
}
public class Silver06_05 {
    public static void main(String[] args) {
        Sample5.num = 10;
        Sample5 s = new Sample5();
        Sample5 s2 = new Sample5();
        s.num += 10;
        s2.num = 30;
        System.out.println(Sample5.num);
    }
}
