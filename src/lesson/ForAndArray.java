package lesson;
public class ForAndArray {

    public static void main(String[] args) {

        String[] names = {
                "田中", "斉藤", "大城", "皆戸", "神藤"
        };
        int[] scores = { 86, 72, 94, 33, 94 };

        int maxScore = scores[0];
        String highestScorer = names[0];

        for (int i = 1; i < names.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                highestScorer = names[i];
            }
        }

        System.out.println("最高得点者: " + highestScorer);
        System.out.println("最高得点: " + maxScore);
    }
}