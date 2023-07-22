package afternoonExam;

public class GhostLegTester {
    public static void main(String[] args) {
        GhostLeg gh = new GhostLeg(4);
        gh.addHorizontalLine(0, 1, 0.8);
        gh.addHorizontalLine(0, 1, 0.2);
        gh.addHorizontalLine(1, 2, 0.4);
        gh.addHorizontalLine(2, 3, 0.6);
        gh.addHorizontalLine(2, 3, 0.2);
        for (int i = 0; i < 4; i++) {
            System.out.printf("%d -> %d%n", i, gh.trace(i));
        }
    }
}
