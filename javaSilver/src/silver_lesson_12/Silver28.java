package silver_lesson_12;

interface A28 {
    public A28 build(String str);
}
public class Silver28 implements A28 {
    public Silver28(String str) {

    }
    @Override
    public Silver28 build(String str) {
        return new Silver28(str);
    }
}
