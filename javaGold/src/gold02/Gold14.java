package gold02;

import java.util.function.BinaryOperator;

public class Gold14 {
    public static void main(String[] args) {
        BinaryOperator<String> b = (str, add) -> str.concat(add);
        System.out.println(b.apply("Hello,","Lambda"));
    }
}

class OperatorFactory {
    public static BinaryOperator<Integer> add() {
        return (a, b) -> a + b;
    }
    public static BinaryOperator<Integer> minus() {
        return (a, b) -> a - b;
    }
}

class UseOperator {
    public static void main(String[] args) {
        BinaryOperator<Integer> op = OperatorFactory.add();
        System.out.println(op.apply(10, 20));
    }
}