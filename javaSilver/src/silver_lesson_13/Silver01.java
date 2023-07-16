package silver_lesson_13;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Silver01 {
    public static void main(String[] args) {
        try {
            test(0);
        } catch (IOException e) {}
    }

    private static void test(int num) throws IOException, IndexOutOfBoundsException {
        if (num < 10) {
            throw new FileNotFoundException();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
