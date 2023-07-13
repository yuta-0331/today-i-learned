package silver_lesson_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Sample2 {
    private int id;
    private String name;
    public Sample2(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}

class SampleComparator implements Comparator<Sample2> {
    @Override
    public int compare(Sample2 s1, Sample2 s2) {
        if (s1.getId() < s2.getId()) {
            return 1;
        }
        if (s1.getId() > s2.getId()) {
            return -1;
        }
        return 0;
    }
}
public class Silver09_02 {
    public static void main(String[] args) {
        Sample2[] samples = {
                new Sample2(2, "B"),
                new Sample2(3, "C"),
                new Sample2(1, "A")
        };

        List<Sample2> list = new ArrayList<>(Arrays.asList(samples));
        list.sort(new SampleComparator());
        for (Sample2 s : list) {
            System.out.println(s.getName());
        }
    }
}
