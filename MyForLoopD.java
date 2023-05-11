public class MyForLoopD {
    public static void main(String[] args) {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("どっかーん！！");
    }
}
