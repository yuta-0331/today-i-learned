package studentManagement;

// *todo クラスはint型で良いのか確認する
// *todo 点数はマイナスはないか確認する
public class Student {
    private int id;
    private int classNum;
    private String name;
    private int englishScore;
    private int mathScore;
    
    public Student(int id, int classNum, String name, int englishScore, int mathScore) {
        this.id = id;
        this.classNum = classNum;
        this.name = name;
        if (englishScore < 0) {
            englishScore = 0;
        }
        this.englishScore = englishScore;
        if (mathScore < 0) {
            mathScore = 0;
        }
        this.mathScore = mathScore;
    }
    public int getId() {
        return id;
    }
    public int getClassNum() {
        return classNum;
    }
    public String getName() {
        return name;
    }
    public int getEnglishScore() {
        return englishScore;
    }
    public int getMathScore() {
        return mathScore;
    }
    
    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEnglishScore(int englishScore) {
        if (englishScore < 0) {
            englishScore = 0;
        }
        this.englishScore = englishScore;
    }
    public void setMathScore(int mathScore) {
        if (mathScore < 0) {
            mathScore = 0;
        }
        this.mathScore = mathScore;
    }

}
