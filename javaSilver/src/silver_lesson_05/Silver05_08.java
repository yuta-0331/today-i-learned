package silver_lesson_05;

public class Silver05_08 {
    public static void main(String[] args) {
        String[][] array = {{"A", "B"}, null, {"C", "D", "E"}};
        int total = 0;
        for (String[] tmp : array) {
            total += tmp.length;
        }
        System.out.println(total);
    }
}
