package silver_lesson_10;

public class Silver10_04 {
    public static void main(String[] args) {
        try {
            Object obj = null;
            System.out.println(obj.toString());
            System.out.println("A");
        } finally {
            System.out.println("B");
        }
//        catch (NullPointerException e) {
//            System.out.println("C");
//        }
    }
}
