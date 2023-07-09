package silver_lesson_06;

class Sample11 {
    private String value;
    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
public class Silver06_11 {
    public static void main(String[] args) {
        Sample11 s = new Sample11();
        s.setValue("hello");
        String val = s.getValue();
        System.out.println(val);
    }
}
