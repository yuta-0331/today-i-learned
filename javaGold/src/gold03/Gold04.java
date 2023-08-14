package gold03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Gold04 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService exec1 = Executors.newSingleThreadScheduledExecutor();
        exec1.schedule(() -> {
            System.out.println("finished");
            exec1.shutdown();
        }, 1, TimeUnit.SECONDS);

        int count = 0;
        while (true) {
            Thread.sleep(100);
            if (exec1.isShutdown()) {
                break;
            }
            System.out.println((++count) * 100 + "ms");
        }
    }
}
