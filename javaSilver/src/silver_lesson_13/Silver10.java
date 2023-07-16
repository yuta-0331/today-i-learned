package silver_lesson_13;

import java.util.ArrayList;

class Sample10 {
    String name;
}
public class Silver10 {
    ArrayList<Sample10> sample = new ArrayList<>();
    public void test() {
        var test = new Sample10[] {new Sample10(), new Sample10()};
        var sample = new Sample10();
        var samples = new ArrayList<>();
        samples.add("java");
        samples.add("lambda");
        for (var s : samples) {
            System.out.println(s);
        }
    }
}
