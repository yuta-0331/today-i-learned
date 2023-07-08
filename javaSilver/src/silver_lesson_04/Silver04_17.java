package silver_lesson_04;

public class Silver04_17 {
    public static void main(String[] args) {
        int total = 0;
        a: for (int i = 0; i < 5; i++) {
            b: for (int j = 0; j < 5; j++) {
            if (i % 2 == 0) continue a;
            if (3 < j) break b;
            total += j;
            }
        }
        System.out.println(total);
     }

}
//i0
//i1 j0 j1 j2 j3
//i2
//i3 j0 j1 j2 j3
//i4