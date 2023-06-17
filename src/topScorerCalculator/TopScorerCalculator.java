package topScorerCalculator;

public class TopScorerCalculator {

	//ハイスコアの生徒を一人算出するメソッド
	public Student searchHighScorer(Student[] students) {
		Student higheScoreStudent = students[0];
		for (Student student : students) {
			if (student.score > higheScoreStudent.score) {
				higheScoreStudent = student;
			}
		}
		return higheScoreStudent;
	}
	//同じ点数の生徒の人数をカウントするメソッド
	public int countSameScorer(Student[] students, int score) {
		int count = 0;
		for (Student student : students) {
			if (student.score == score) {
				count++;
			}
		}
		return count;
	}
	//同じ点数の生徒を配列に格納するメソッド
	public Student[] searchSameScorer(Student[] students, int score, int count) {
		Student[] sameScoreStudents = new Student[count];
		for (int i = 0, j = 0; i < students.length && j < count; i++) {
			if (students[i].score == score) {
				sameScoreStudents[j++] = students[i];
			}
		}
		return sameScoreStudents;
	}
}
