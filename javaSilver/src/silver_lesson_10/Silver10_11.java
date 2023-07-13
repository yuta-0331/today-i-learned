package silver_lesson_10;

class SampleException11 extends Exception {}
class TestException11 extends RuntimeException {}
public class Silver10_11 {
    public void hello(String name) throws SampleException11, TestException11 {
        if (name == null) {
            throw new SampleException11();
        }
        if ("".equals(name)) {
            throw new TestException11();
        }
    }
}
