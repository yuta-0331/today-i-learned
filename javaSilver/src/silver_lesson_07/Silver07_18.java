package silver_lesson_07;

class Sample18 {
    private int num;
    public Sample18(int num) {
        setNum(num);
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
public class Silver07_18 {
    public static void main(String[] args) {
        Sample18 s = new Sample18(10);
        System.out.println(s.getNum());
    }
}
