class A {
    public void test() {
        System.out.println("S");
    }
}
class B extends A {
    @Override
    public void test() {
        System.out.println("B");
    }
}
class C extends A {
    @Override
    public void test() {
        System.out.println("C");
    }
}
public class Silver2_8 {
    public static void main(String[] args) {
        var a = new B();
//        a = new C();
        a.test();
    }
}