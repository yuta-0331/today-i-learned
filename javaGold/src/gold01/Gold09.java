package gold01;

interface A {
    static void test() {
        System.out.println("A");
    }
}
interface B extends A {}
class C implements A {}
public class Gold09 {
    public static void main(String[] args) {
        A.test();
//        B.test();
//        C.test();
//        test();
    }
}
