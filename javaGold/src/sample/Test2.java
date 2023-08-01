package sample;

interface Decorator {
    void decorate(String msg, String symbol);
}
interface Improver {
    int improve(int value);
}

public class Test2 {

    public static void main(String[] args) {
        Decorator dec = (String m, String s) -> System.out.println(s + m + s);
        dec.decorate("Hello", "+++");

        Improver imp = v -> { return v * 2; };
        System.out.println(imp.improve(5));
    }

}
