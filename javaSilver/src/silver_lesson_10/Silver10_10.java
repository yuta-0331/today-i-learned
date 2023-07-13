package silver_lesson_10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Silver10_10 {
    public static void main(String[] args) {
        try (FileInputStream is = new FileInputStream("sample.txt")) {
            throw new FileNotFoundException();
        } catch (Exception e) {
            System.out.println("A");
        } finally {
//            if (is != null) {
//                is.close();
//            }
            System.out.println("B");
        }
    }
}
