package gold01;

interface Test {
    void execute();
}

class Sample06 {
    private String message;
    public Test test(String value) {
        class A implements Test {
            @Override
            public void execute() {
                System.out.println(message + value);
            }
        }
//        value = "LocalClass";
        message = "Hello, ";
        return new A();
    }
}
public class Gold06 {
    public static void main(String[] args) {
        new Sample06()
                .test("java")
                .execute();
    }
}
