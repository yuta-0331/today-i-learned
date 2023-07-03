package topScorerCalculator;

import java.util.ArrayList;

public class TopScorerCalculator {
	private ArrayList<Student> students;

	public TopScorerCalculator(ArrayList<Student> students) {
		this.students = students;
	}
	public TopScorerCalculator(String[] names, int[] scores) {
		students = new ArrayList<>();
		//names, scoresからStudentリストを作成
		for (int i = 0; i < names.length; i++) {
			students.add(new Student(names[i], scores[i] ));
		}
	}

	//ハイスコアを算出するメソッド
	public int searchHighScore() {
		Student higheScoreStudent = students.get(0);
		for (Student student : students) {
			if (student.getScore() > higheScoreStudent.getScore()) {
				higheScoreStudent = student;
			}
		}
		return higheScoreStudent.getScore();
	}
	//同じ点数の生徒を配列に格納するメソッド
	public ArrayList<Student> searchSameScorer(int score) {
		ArrayList<Student> sameScoreStudents = new ArrayList<>();
		for (Student student : students) {
			if (student.getScore() == score) {
				sameScoreStudents.add(student);
			}
		}
		return sameScoreStudents;
	}
	//計算の実行
	public ArrayList<Student> calculator() {
		int highScore = searchHighScore();
		return searchSameScorer(highScore);
	}
	//表示
	public void displayStudents(ArrayList<Student> students) {
		for (Student student : students) {
			System.out.print(student.getName() + " ");
		}
	}
	//最高得点者の表示
	public void displayHighScorer() {
		System.out.print("最高得点者:");
		displayStudents(calculator());
		System.out.print("最高得点:" + searchHighScore());
	}
}
