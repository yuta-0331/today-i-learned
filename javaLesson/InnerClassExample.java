class Outer {
    private String message = "Outer classのprivateなインスタンス変数です。";
    
    void doSomething() {
        class Inner {
            void print() {
                System.out.println("Inner classのprintのメソッドが呼ばれました");
                System.out.println(message);
            }
        }
        Inner inner = new Inner();
        inner.print();
    }
}

public class InnerClassExample {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.doSomething();
    }
}
