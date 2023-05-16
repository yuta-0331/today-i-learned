import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyConsole {
    public static String readLine() {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return str;
    }
}
