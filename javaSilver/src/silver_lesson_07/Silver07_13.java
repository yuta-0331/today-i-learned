package silver_lesson_07;

interface Worker13 {
    void work();
}
class Employee13 {
    public void work() {
        System.out.println("work");
    }
}

class Engineer extends Employee13 implements Worker13 {}

public class Silver07_13 {
    public static void main(String[] args) {
        Worker13 worker = new Engineer();
        worker.work();
    }
}
