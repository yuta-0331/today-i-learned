package lesson;

public class BubbleSort {

	public static void doSort(int[] args) {
		for (int i = 0; i < args.length - 1; i++) {
			for (int j = 0; j < args.length - 1 - i; j++) {
				if (args[j] > args[j + 1]) {
					int temp = args[j];
					args[j] =  args[j + 1];
					args[j + 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = { 3, 4, 5, 6, 2, 1 };
		doSort(numbers);
		for (int number : numbers) {
			System.out.println(number);
		}
	}

}
