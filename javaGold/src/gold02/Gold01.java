package gold02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Gold01 {
    public static void main(String[] args) {
        Supplier<List<String>> supplier = () -> new ArrayList();
        List<String> list = supplier.get();
    }
}
