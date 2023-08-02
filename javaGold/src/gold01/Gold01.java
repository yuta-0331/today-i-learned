package gold01;

public class Gold01 {
    private class Inner1 {}
    public static class Inner2 {}

    void outerMethod() {
        int i = 10;
        class localClass {}
        new Inner1() {};
    }
}
