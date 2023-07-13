package silver_lesson_10;

public class Silver10_01 {
    public static void main(String[] args) {
        try {
            int[] array = {};
            array[0] = 10;
            System.out.println("finish");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error");
        }
    }
}
