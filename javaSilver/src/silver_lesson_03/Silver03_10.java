package silver_lesson_03;

class Sample3 {
    private int num;
    public Sample3(int num) {
        this.num = num;
    }
    public boolean equals(Sample3 obj) {
        if (obj == null) {
            return false;
        }
        return this.num == obj.num;
    }
}
public class Silver03_10 {
    public static void main(String[] args) {
        Object a = new Sample3(10);
        Object b = new Sample3(10);
        System.out.println(a.equals(b));
    }
}
