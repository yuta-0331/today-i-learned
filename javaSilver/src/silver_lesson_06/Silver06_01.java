package silver_lesson_06;

class Item1 {
    private int num = 10;
    public void setNum(int num) {
        this.num = num;
    }
    public int getNum() {
        return this.num;
    }
}
public class Silver06_01 {
    public static void main(String[] args) {
        Item1 a = new Item1();
        Item1 b = new Item1();
        b.setNum(20);
        System.out.println(a.getNum());
    }
}
