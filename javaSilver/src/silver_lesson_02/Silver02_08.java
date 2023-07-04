package silver_lesson_02;

class A {
    public void test() {
        System.out.println("S");
    }
}
class B extends A {
    @Override
    public void test() {
        System.out.println("silver_lesson_02.B");
    }
}
class C extends A {
    @Override
    public void test() {
        System.out.println("silver_lesson_02.C");
    }
}
public class Silver02_08 {
    public static void main(String[] args) {
        var a = new B();
        //        a = new silver_lesson_02.C();
        a.test();
    }

    public void lesson2_9() {
        String a = new String("sample");
        String b = "sample";
        //        String c = String.newInstance("sample");
        //        String d = String.valueOf('sample');
    }
}