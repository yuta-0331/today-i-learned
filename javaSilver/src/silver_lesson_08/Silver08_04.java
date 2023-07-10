package silver_lesson_08;

public class Silver08_04 {
    public static void main(String[] args) {
//        int cnt = 0;
        Runnable r = () -> {
            for (int cnt = 0; cnt < 10; cnt++) {
                System.out.println(cnt++);
            }
        };
        new Thread(r).start();
    }
}
