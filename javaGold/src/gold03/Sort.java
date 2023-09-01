package gold03;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        sort(arr);
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
