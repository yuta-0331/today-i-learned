package gold03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Gold05 {
    public static void main(String[] args) throws Exception {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

        exec.scheduleAtFixedRate(() -> {
            System.out.println("interrupt");
        }, 1, 1, TimeUnit.SECONDS);

        int count = 0;
        while (true) {
            Thread.sleep(100);
            System.out.print(">");
            count++;
            if (count == 100) {
                exec.shutdown();
                break;
            }
        }
    }
}
