package silver_lesson_04;

public class Silver04_13 {
    public static void main(String[] args) {
        int num = 10;
        do {
            num++;
        } while (++num < 10);
        System.out.println(num);

        int number = 10;
        while (number++ <= 10) {
            number++;
        }
        System.out.println(number);
     }

}
