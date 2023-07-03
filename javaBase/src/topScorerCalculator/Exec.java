package topScorerCalculator;

import java.util.ArrayList;
import java.util.List;

public class Exec {
    public static void main(String[] args) {

        String[] names = {
                "田中", "斉藤", "大城", "皆戸", "神藤"
        };
        int[] scores = { 86, 72, 94, 33, 94 };

        new TopScorerCalculator(names, scores).displayHighScorer();
    }
}
