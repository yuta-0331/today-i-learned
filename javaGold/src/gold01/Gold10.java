package gold01;

interface Sample10 {
    static void test() {
        System.out.println("A");
    }
}
public class Gold10 implements Sample10 {
    public void test() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        Sample10.test();
    }
}
