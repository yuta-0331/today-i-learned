import java.util.Arrays;

public class MyForLoopC {
    public static void main(String[] args) {
        //3の倍数の数値の入った配列ahoNumArrayを用意
        Integer[] ahoNumArray = new Integer[10];
        for (int i = 0; i < ahoNumArray.length; i++) {
            ahoNumArray[i] = (i  + 1) * 3;
        }

        for (int i = 1; i <= 30; i++) {
            //ahoNumArrayに含まれるかどうかで3の倍数を判定する
            if (Arrays.asList(ahoNumArray).contains(i)) {
                System.out.println(i + "AHO");
            } else {
                System.out.println(i);
            }
        }
    }
}
