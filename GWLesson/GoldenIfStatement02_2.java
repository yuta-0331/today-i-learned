package GWLesson;

import java.util.Scanner;

public class GoldenIfStatement02_2 {
    public static void main(String[] args) {
        System.out.println("電車なら1を、バスなら2を入力してください");
        Scanner inputMeansOfTransportation = new Scanner(System.in);
        int meansOfTransportation = Integer.parseInt(
            inputMeansOfTransportation.nextLine()
        );

        if (meansOfTransportation == 1) {
            System.out.println("電車は安くていいですね");
        } else if (meansOfTransportation == 2) {
            System.out.println("バスは目的地近くまで行けていいですね");
        } else {
            System.out.println("1か2を入力してください");
        }

        inputMeansOfTransportation.close();
    }
}
