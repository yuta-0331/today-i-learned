import java.util.Arrays;

public class MyForLoopC {
    public static void main(String[] args) {
        Integer[] ahoNum = new Integer[10];
        for (int i = 0; i < ahoNum.length; i++) {
            ahoNum[i] = (i  + 1) * 3;
        }

        for (int i = 1; i <= 30; i++) {
            if (Arrays.asList(ahoNum).contains(i)) {
                System.out.println(i + "AHO");
            } else {
                System.out.println(i);
            }
        }
    }
}
