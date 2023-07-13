package silver_lesson_10;

class SampleException3 extends Exception {}

class SubSampleException3 extends SampleException3 {}
public class Silver10_03 {
    public static void main(String[] args) {
        try {
            sample();
            sub();
        } catch (SampleException3 e) {
            System.out.println("A");
        }
//        catch (SubSampleException3 e) {
//            System.out.println("B");
//        }
    }
    private static void sample() throws SampleException3 {
        throw new SampleException3();
    }
    private static void sub() throws SubSampleException3 {
        throw new SubSampleException3();
    }
}
