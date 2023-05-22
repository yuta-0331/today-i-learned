package lesson;

public class TopScorerCalculator {

	public static void main(String[] args) {

		String[] names = {
				"田中", "斉藤", "大城", "皆戸", "神藤"
		};
		int[] scores = { 86, 72, 94, 33, 94 };
		
		int index = 0;
		for (int i = 1; i < names.length; i++) {
			if (scores[i] > scores[index]) {
				index = i;
			}
		}
		System.out.print("最高得点者:");
		for (int i = 0; i < names.length; i++) {
			if (scores[i] == scores[index]) {
				System.out.print(names[i] + " ");
			}
		}
		System.out.print("最高得点:" + scores[index]);
	}

}
