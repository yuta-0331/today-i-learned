package lesson;

class Student {
	String name;
	int score;
}

public class TopScorerCalculator {

	//ハイスコアの生徒を一人算出するメソッド
	public static Student searchHighScorer(Student[] students) {
		Student higheScoreStudent = students[0];
		for (Student student : students) {
			if (student.score > higheScoreStudent.score) {
				higheScoreStudent = student;
			}
		}
		return higheScoreStudent;
	}
	//同じ点数の生徒の人数をカウントするメソッド
	public static int countSameScorer(Student[] students, int score) {
		int count = 0;
		for (Student student : students) {
			if (student.score == score) {
				count++;
			}
		}
		return count;
	}
	//同じ点数の生徒を配列に格納するメソッド
	public static Student[] searchSameScorer(Student[] students, int score, int count) {
		Student[] sameScoreStudents = new Student[count];
		for (int i = 0, j = 0; i < students.length && j < count; i++) {
			if (students[i].score == score) {
				sameScoreStudents[j++] = students[i];
			}
		}
		return sameScoreStudents;
	}
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
		
		Student highScorer = searchHighScorer(students);
		int count = countSameScorer(students, highScorer.score);
		Student[] sameStudent = searchSameScorer(students, highScorer.score, count);
		
		System.out.print("最高得点者:");
		for (int i = 0; i < count; i++) {
			System.out.print(sameStudent[i].name + " ");
		}
		System.out.print("最高得点:" + highScorer.score);
	}

}
