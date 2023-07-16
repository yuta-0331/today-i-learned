package silver_lesson_13;

import java.util.Collection;
import java.util.List;
import java.util.Map;

class A31 {
    private Collection collection;
    public void set(Collection collection) {
        this.collection = collection;
    }
}
public class Silver31 extends A31 {
    public void set(Map<String, String> map) {
        set(map.values());
    }
}
