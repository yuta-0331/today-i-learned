class MyThread implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThreadのrunメソッド(" + i + ")");
        }
    }
}

public class SimpleThreadTest3 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        Thread thread = new Thread(t);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("SimpleThreadTestのmainメソッド(" + i + ")");
        }
    }
}
