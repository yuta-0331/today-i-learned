package gold02;

import java.util.function.Supplier;

interface A02 {
    void hello();
}
class B02 implements A02 {
    @Override
    public void hello() {
        System.out.println("Bの独自処理");
    }
}
class C02 implements A02 {
    @Override
    public void hello() {
        System.out.println("Cの独自処理");
    }
}
class Factory02 {
    public static A02 create() {
        return new B02();
    }
}
class Test02_1 {
    public void execute() {
        System.out.println("お決まりの事前処理");
        A02 a = Factory02.create();
        a.hello();
        System.out.println("お決まりの事後処理");
    }
}

class Test02_2 {
    public void execute(Supplier<A02> supplier) {
        System.out.println("お決まりの事前処理");
        A02 a = supplier.get();
        a.hello();
        System.out.println("お決まりの事後処理");
    }
}

public class Gold02 {
    public static void main(String[] args) {
        Test02_1 test1 = new Test02_1();
        test1.execute();
        Test02_2 test2 = new Test02_2();
        test2.execute(() -> new B02());
        Test02_2 test3 = new Test02_2();
        test3.execute(C02::new);
    }
}
