package silver_lesson_12;

public class Silver72 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("ABCD");
        sb.replace(sb.indexOf("B"), sb.indexOf("C"), "X");
        System.out.println(sb);
    }
}
