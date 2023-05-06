package GWLesson;

import java.util.Scanner;

public class GoldenIfStatement02 {
    public static void main(String[] args) {

        System.out.println("お名前は？");
        Scanner inputNameScanner = new Scanner(System.in);
        String inputName = inputNameScanner.nextLine();

        System.out.println("生まれ年は？");
        Scanner inputYearScanner = new Scanner(System.in);
        int inputYear = inputYearScanner.nextInt();
        
        if (inputYear >= 2000) {
            System.out.println(
                inputName + "さんは、2000年以降に生まれました。"
            );
        } else {
            System.out.println(
                inputName + "さんは、2000年より前に生まれました。"
            );
        }
        inputNameScanner.close();
        inputYearScanner.close();
    }
}
