package topScorerCalculator;

import java.util.ArrayList;
import java.util.List;

public class Exec {
    public static void main(String[] args) {

        String[] names = {
                "田中", "斉藤", "大城", "皆戸", "神藤"
        };
        int[] scores = { 86, 72, 94, 33, 94 };

        //names, scoresからStudentリストを作成
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            students.add(new Student(names[i], scores[i] ));
        }

        TopScorerCalculator calculator = new TopScorerCalculator(students);
        calculator.displayHighScorer();
    }
}
