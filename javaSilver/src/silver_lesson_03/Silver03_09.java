package silver_lesson_03;

class Sample2 {
    private int num;
    private String name;
    public Sample2(int num, String name) {
        this.num = num;
        this.name = name;
    }
    public boolean equals(Sample2 obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Sample2) {
            Sample2 s = (Sample2) obj;
            return s.num == this.num;
        }
        return false;
    }
}

public class Silver03_09 {
    public static void main(String[] args) {
        Sample2 a = new Sample2(10, "a");
        Sample2 b = new Sample2(10, "b");
        System.out.println(a.equals(b));
    }
}
