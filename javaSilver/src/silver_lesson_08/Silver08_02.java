package silver_lesson_08;

public class Silver08_02 {
    public static void main(String[] args) {
        Function f = (name) -> {
            return "hello, " + name;
        };
//        Function g = (name) -> {
//            "hello, " + name;
//        };
//        Function h = (name) -> return "hello, " + name;
        Function i = (name) -> "hello, " + name;
        Function j = name -> {
            return "hello, " + name;
        };
        System.out.println(f.test("Lambda"));
    }
    private static interface Function {
        String test(String name);
    }


}
