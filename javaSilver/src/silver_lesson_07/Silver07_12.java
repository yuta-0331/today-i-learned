package silver_lesson_07;
abstract class AbstractSample9{
    public void sample() {
        System.out.println("A");
        test();
        System.out.println("C");
    }

    protected abstract void test();
}

class ConcreteSample9 extends AbstractSample9 {
    @Override
    protected void test() {
        System.out.println("B");
    }
}

public class Silver07_09 {
    public static void main(String[] args) {
        AbstractSample9 s = new ConcreteSample9();
        s.sample();
    }
}
