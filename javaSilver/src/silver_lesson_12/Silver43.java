package silver_lesson_12;

class A43 {
    private boolean isValue(int val) {
        return true;
    }
}
public class Silver43 extends A43 {
    public int test(int num) {
//        if (isValue(num)) {
//            return num;
//        }
        return 0;
    }

    public static void main(String[] args) {
        Silver43 b = new Silver43();
        System.out.println(b.test(10));
    }
}
