package silver_lesson_13;

public class Silver71 {
    public static void main(String[] args) throws Exception {
        try {
            if (args.length == 0) {
                sample(null);
            } else {
                sample(args[0]);
            }
        } catch (RuntimeException e) {
            System.out.println("error");
        }
    }
    private static void sample(String str) throws Exception {
        if (str == null) throw new Exception();
        throw new RuntimeException();
    }
}
