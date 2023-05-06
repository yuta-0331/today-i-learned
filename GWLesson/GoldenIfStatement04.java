package GWLesson;

import java.util.Scanner;

public class GoldenIfStatement04 {
    public static void main(String[] args) {
        System.out.println("お名前は？");
        Scanner inputNameScanner = new Scanner(System.in);
        String inputName = inputNameScanner.nextLine();

        System.out.println("生まれ年は？");
        Scanner inputBirthYearScanner = new Scanner(System.in);
        int birthYear = inputBirthYearScanner.nextInt();

        String generation;

        if (birthYear <= 1969) {
            generation = "ベビーブーマー世代";
        } else if (birthYear <= 1979) {
            generation = "氷河期世代";
        } else if (birthYear <= 1999) {
            generation = "ミレニアム世代";
        } else {
            generation = "Z世代";
        }

        System.out.println(
            inputName + "さんは" + generation + "です。"
        );

        inputBirthYearScanner.close();
        inputNameScanner.close();
    }
}
