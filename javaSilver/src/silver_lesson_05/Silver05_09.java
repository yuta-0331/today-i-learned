package silver_lesson_05;

interface A {}
abstract class B implements A {}
class C extends B {}
class D extends C {}
public class Silver05_09 {
    public static void main(String[] args) {
        A[] array = {new C(), null, new D()};
        Object[] objArray = array;
    }
}
