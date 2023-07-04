package silver_lesson_03;

class Sample2 {
    private int num;
    public Sample2(int num) {
        this.num = num;
    }
    public boolean equals(Sample2 obj) {
        if (obj == null) {
            return false;
        }
        return this.num == obj.num;
    }
}

public class Silver03_09 {
    public static void main(String[] args) {
        Object a = new Sample2(10);
        Object b = new Sample2(10);
        System.out.println(a.equals(b));
    }
}
