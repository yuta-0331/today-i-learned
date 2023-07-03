package fileIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        try {
            BufferedWriter bw = Files.newBufferedWriter(
                    Paths.get("test.csv"),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            while (true) {
                System.out.print("title: ");
                String title = scanner.nextLine();
                if (title.equals("")) {
                    break;
                }
                System.out.print("price: ");
                int price = Integer.parseInt(scanner.nextLine());
                books.add(new Book(title, price));
            }
            scanner.close();
            for (Book book : books) {
                bw.write(book.getTitle() + "," + book.getPrice());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
