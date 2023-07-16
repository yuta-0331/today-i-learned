package silver_lesson_13;

public class Silver34 {
    public static void main(String[] args) {
        int[][] array = new int[2][4];
        array[0] = new int[]{1, 2, 3, 4};
        array[1] = new int[]{1, 2};
        for (int[] a : array) {
            for (int b : a) {
                System.out.println(b);
            }
            System.out.println();
        }
    }
}
