package gold03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gold03 {
    public static void main(String[] args) {
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
    }
}
