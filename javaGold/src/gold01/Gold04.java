package gold01;

public class Gold04 {
    private static int num = 2;
    public void hoge() {
        Inner test = new Inner();
        test.data = 100;
        test.execute();
    }

    private static class Inner {
        private int data;
        void execute() {
            System.out.println(num * data);
        }
    }
}
