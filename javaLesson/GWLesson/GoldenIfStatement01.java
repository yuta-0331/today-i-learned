package GWLesson;

import java.util.Scanner;

public class GoldenIfStatement01 {
    public static void main(String[] args) {
        System.out.println("商品の金額は？");
        Scanner inputPrice = new Scanner(System.in);
        int price = inputPrice.nextInt();

        if (price >= 10000) {
            System.out.println("贅沢ですね");
        } else {
            System.out.println("お買い得ですね");
        }

        inputPrice.close();
    }
}
