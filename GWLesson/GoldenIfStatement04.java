package GWLesson;

import java.util.Scanner;

public class GoldenIfStatement04 {
    public static void main(String[] args) {
        System.out.println("お名前は？");
        Scanner inputNameScanner = new Scanner(System.in);
        String inputName = inputNameScanner.nextLine();

        System.out.println("生まれ年は？");
        Scanner inputBirthYearScanner = new Scanner(System.in);
        int birthYear;
        try {
            birthYear = inputBirthYearScanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            inputBirthYearScanner.close();
            inputNameScanner.close();
            return;
        }

        System.out.println("男性なら1を、女性なら2を入力してください");
        Scanner inputSexNumScanner = new Scanner(System.in);
        int inputSexNum;
        try {
            inputSexNum = inputBirthYearScanner.nextInt();
            if (inputSexNum != 1 && inputSexNum != 2) {
                System.out.println("1か2を入力してください");
                inputNameScanner.close();
                inputBirthYearScanner.close();
                inputSexNumScanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("数値で入力してください");
            inputNameScanner.close();
            inputBirthYearScanner.close();
            inputSexNumScanner.close();
            return;
        }

        String generation;

        if (inputSexNum == 2) {
            generation = "いつまでもシンデレラ";
        } else if (birthYear <= 1969) {
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
        inputSexNumScanner.close();
    }
}
