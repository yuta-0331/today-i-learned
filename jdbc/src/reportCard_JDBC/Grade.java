package reportCard_JDBC;

public class Grade {
    private int id;
    private String team;
    private String name;
    private int englishScore;
    private int mathScore;
    
    public Grade(int id, String team, String name, int englishScore, int mathScore) {
        this.id = id;
        this.team = team;
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }
    
    public int getId() {
        return id;
    }
    public String getTeam() {
        return team;
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
}
