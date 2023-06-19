package studentManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Model {
    private int finalDigit; // 末尾のdataのid

    public int getFinalDigit() {
        return finalDigit;
    }
    public ArrayList<Student> readFile() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("reportcards.csv"), Charset.defaultCharset());
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                int id = Integer.parseInt(cols[0]);
                int classNum = Integer.parseInt(cols[1]);
                String name = cols[2];
                int englishScore = Integer.parseInt(cols[3]);
                int mathScore = Integer.parseInt(cols[4]);
                finalDigit = id;

                Student student = new Student(id, classNum, name, englishScore, mathScore);
                students.add(student);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("ファイル読み込みに失敗しました");
            e.printStackTrace();
        }
        return students;
    }

    // 修正データをファイルに書き込むメソッド
    public void writeData(ArrayList<Student> students) {
        try {
            BufferedWriter bw = Files.newBufferedWriter(
                    Paths.get("reportcards.csv"),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            for (Student student : students) {
                bw.write(student.getId() + "," + student.getClassNum() + "," + student.getName()
                        + "," + student.getEnglishScore() + "," + student.getMathScore());
                bw.newLine();
            }
            bw.close();
            System.out.println("保存しました。終了。");
        } catch (IOException e) {
            System.out.println("保存に失敗しました");
            e.printStackTrace();
        }
    }
}
