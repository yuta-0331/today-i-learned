package silver_lesson_02;

public class Silver02_10 {
    public static void main(String[] args) {
        String str = "hoge, world";
        hello(str);
        System.out.println(str);
    }
    public static void hello(String msg) {
        msg.replaceAll("hoge", "hello");
    }
}
