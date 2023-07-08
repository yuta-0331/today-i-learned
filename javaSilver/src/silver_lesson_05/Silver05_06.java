package silver_lesson_05;

public class Silver05_06 {
    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D"};
        array[0] = null;
        for (String str : array) {
            System.out.print(str);
        }
    }
}
