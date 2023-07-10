package silver_lesson_08;

interface Algorithm {
    void perform(String name);
}

class Service {
    private Algorithm logic;
    public void setLogic(Algorithm logic) {
        this.logic = logic;
    }
    public void doProcess(String name) {
        System.out.println("start");
        this.logic.perform(name);
        System.out.println("end");;
    }
}
public class Silver08_01 {
    public static void main(String[] args) {
        Algorithm algorithm = (String name) -> {
            System.out.println("hello, " + name);
        };
        Service s = new Service();
        s.setLogic(algorithm);
        s.doProcess("Lambda");
    }


}
