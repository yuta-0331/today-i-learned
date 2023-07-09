package silver_lesson_07;

class Parent19 {
    String name;
    String getName() {
        return this.name;
    }
}

class Child19 extends Parent19 {
    String name;
}
public class Silver07_19 {
    public static void main(String[] args) {
        Child19 child = new Child19();
        child.name = "sample";
        System.out.println(child.getName());
    }
}
