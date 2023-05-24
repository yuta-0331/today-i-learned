package lesson;

public class TopScorerCalculator {

	public static void main(String[] args) {

		String[] names = {
				"田中", "斉藤", "大城", "皆戸", "神藤"
		};
		int[] scores = { 86, 72, 94, 33, 94 };

		int index = 0;
		int count = 1;
		for (int i = 1; i < names.length; i++) {
			if (scores[i] > scores[index]) {
				index = i;
				count = 1;
			} else if (scores[i] == scores[index]) {
				count++;
			}
		}
		int[] topScorerIndexs = new int[count];
		for (int i = 0, j = 0; i < names.length && j < count; i++) {
			if (scores[i] == scores[index]) {
				topScorerIndexs[j++] = i;
			}
		}
		
		System.out.print("最高得点者:");
		for (int i = 0; i < count; i++) {
			System.out.print(names[topScorerIndexs[i]] + " ");
		}
		System.out.print("最高得点:" + scores[index]);
	}

}
