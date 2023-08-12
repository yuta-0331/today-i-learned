package gold03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gold03 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec1.submit(() -> {
                System.out.println(Thread.currentThread().getId());
            });
        }

        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            exec2.submit(() -> {
                System.out.println(Thread.currentThread().getId());
            });
        }

        ExecutorService exec3 = Executors.newCachedThreadPool();
        Runnable test = () -> {
            System.out.println(Thread.currentThread().getId());
        };

        for (int i = 0; i < 5; i++) {
            exec3.submit(test);
        }

        Thread.sleep(10000);
        System.out.println("---------10秒後----------");

        for (int i = 0; i < 5; i++) {
            exec3.submit(test);
        }

        Thread.sleep(70000);
        System.out.println("---------70秒後----------");

        for (int i = 0; i < 5; i++) {
            exec3.submit(test);
        }
    }
}
