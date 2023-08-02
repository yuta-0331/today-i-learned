package gold01;

public class Gold02 {
    class Inner {
        public void test() {
            System.out.println("test");
        }
    }

    public static void main(String[] args) {
        new Gold02().new Inner();
    }
}

interface Sample {
    void execute();
}
class SampleFactory {
    public static Sample create() {
        return new SampleFactory().new SampleImpl();
    }
    private class SampleImpl implements Sample {
        public void test() {
            System.out.println("test");
        }
        @Override
        public void execute() {
            System.out.println("execute");
        }
    }
}