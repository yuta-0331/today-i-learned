package topScorerCalculator;

public class Exec {
    public static void main(String[] args) {

        String[] names = {
                "田中", "斉藤", "大城", "皆戸", "神藤"
        };
        int[] scores = { 86, 72, 94, 33, 94 };

        //names, scoresからStudent配列を作成
        Student[] students = new Student[names.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].name = names[i];
            students[i].score = scores[i];
        }

        TopScorerCalculator calculator = new TopScorerCalculator();

        Student highScorer = calculator.searchHighScorer(students);
        int count = calculator.countSameScorer(students, highScorer.score);
        Student[] sameStudent = calculator.searchSameScorer(students, highScorer.score, count);

        System.out.print("最高得点者:");
        for (int i = 0; i < count; i++) {
            System.out.print(sameStudent[i].name + " ");
        }
        System.out.print("最高得点:" + highScorer.score);
    }
}
