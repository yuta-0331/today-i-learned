package silver_lesson_09;

import java.util.Arrays;
import java.util.List;

public class Silver09_04 {
    public static void main(String[] args) {
        char a = '0';
        int num = 0;
        if (Character.isAlphabetic(a)) {
            num++;
        }
        if (Character.isDigit(a)) {
            num++;
        }
        if (Character.isLowerCase(a)) {
            num++;
        }
        System.out.println(num);
    }
}
