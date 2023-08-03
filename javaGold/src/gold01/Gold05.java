package gold01;

public class Gold05 {
    void test() {
        Inner.message = "Hello, Java";
    }
    static class Inner {
        private static String message;
        public void test() {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Gold05 outer = new Gold05();
        outer.test();
        new Inner().test();
    }
}
