package lesson;

public class TopScorerCalculator {

	public static void main(String[] args) {

		String[] names = {
				"田中", "斉藤", "大城", "皆戸", "神藤"
		};
		int[] scores = { 86, 72, 94, 33, 94 };

		int highScore = scores[0];
		int count = 1;
		for (int i = 1; i < names.length; i++) {
			if (scores[i] > highScore) {
				highScore = scores[i];
				count = 1;
			} else if (scores[i] == highScore) {
				count++;
			}
		}
		int[] topScorerIndexs = new int[count];
		for (int i = 0, j = 0; i < names.length && j < count; i++) {
			if (scores[i] == highScore) {
				topScorerIndexs[j++] = i;
			}
		}
		
		System.out.print("最高得点者:");
		for (int i = 0; i < count; i++) {
			System.out.print(names[topScorerIndexs[i]] + " ");
		}
		System.out.print("最高得点:" + highScore);
	}

}
