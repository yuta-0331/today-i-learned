package silver_lesson_07;

interface Worker14 {
    void work();
}
class Employee14 implements Worker14 {
    public void work() {
        System.out.println("work");
    }
    public void report() {
        System.out.println("report");
    }
}

class Engineer14 extends Employee14 {
    public void create() {
        System.out.println("create future");
    }
}

public class Silver07_14 {
    public static void main(String[] args) {
        Worker14 a = new Engineer14();
        Employee14 b = new Engineer14();
        Engineer14 c = new Engineer14();
//        a.create();
        b.work();
        c.report();
    }
}
