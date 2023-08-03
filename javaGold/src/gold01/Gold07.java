package gold01;

class Sample07 {
    private int num;
    public Sample07(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
public class Gold07 {
    public static void main(String[] args) {
        var sample = new Sample07(10){
            void modify(int num) {
                setNum(num);
            }
        };
        sample.modify(100);
        System.out.println(sample.getNum());
    }
}
