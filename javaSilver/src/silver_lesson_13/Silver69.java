package silver_lesson_13;

public class Silver69 {
    public static void main(String[] args) {
        String[] array = {"A", "B"};
        int i = 0;
        while (i < array.length) {
            int j = 0;
            do {
                ++j;
                System.out.println(array[i].length());
            } while (j < array[i].length());
            System.out.println(array[i] + ":" + j);
            i++;
        }
    }
}
