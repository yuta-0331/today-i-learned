package gold03;

public class Test {
    public static void main(String[] args) {
        int[][] arrays = {{1, 3, 5, 7}, {5, 10, 15, 20, 25}, {10, 20, 30, 40, 50, 60}};
        int maxLength = arrays[0].length;

        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i].length > maxLength) {
                maxLength = arrays[i].length;
            }
        }

        int[] verticalSum = new int[maxLength];
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                verticalSum[j] += arrays[i][j];
                System.out.print(arrays[i][j] +"\t");
            }
            System.out.println();
        }

        for (int vsum : verticalSum) {
            System.out.print(vsum + "\t");
        }
    }
}
