package silver_lesson_04;

public class Silver04_09 {
    public static void main(String[] args) {
       int[][] array = new int[][] {{1, 2}, {2, 3,  4}};
       int total = 0;
       for (int i = 0; i < array.length; i++) {
           for (int j = i; j < array[i].length; j++) {
               total += array[i][j];
           }
       }
        System.out.println(total);
    }

}
