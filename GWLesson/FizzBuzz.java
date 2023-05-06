package GWLesson;

import java.util.Scanner;

public class FizzBuzz {

    static String getFizzBuzz(int num) {
        if (num % 15 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(num);
        }
    }

    public static void main(String[] args) {
        System.out.println("数字を入力してください");
        Scanner inputNumberScanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(inputNumberScanner.nextLine());

        for (int i = 1; i <= inputNumber; i++) {
            String fizzBuzz = getFizzBuzz(i);
            System.out.println(fizzBuzz);
        }
        inputNumberScanner.close();
    }
}
