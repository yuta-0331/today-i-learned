package gold01;

import java.util.ArrayList;
import java.util.List;

class Sample08 {
    public Sample08() {
        System.out.println("A");
    }
}
public class Gold08 {
    public static void main(String[] args) {
        Sample08 sample = new Sample08() {
            {
                System.out.println("B");
            }
        };
    }
}
class ListSample08 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {
                super.add("A");
                super.add("B");
                super.add("C");
            }
        };
        for (String str : list) {
            System.out.println(str);
        }
    }
}
