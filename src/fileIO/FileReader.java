package fileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static void main(String[] args) {
        try {
            BufferedReader br = Files.newBufferedReader(
                    Paths.get("test.csv"),
                    Charset.defaultCharset()
            );
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
