package gold03;

public class Gold01 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public synchronized void start() {
                super.start();
                System.out.println("A");
            }
            @Override
            public void run() {
                super.run();
                System.out.println("B");
            }
        };
        t.start();
    }
}
