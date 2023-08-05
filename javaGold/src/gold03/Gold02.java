package gold03;

public class Gold02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sub1");
            }
        });
        Thread t2 = new Thread(() -> System.out.println("sub2"));
        t1.start();
        t2.start();
        System.out.println("main");
    }
}
