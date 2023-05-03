package GWLesson;

import java.util.Scanner;

public class GoldenIfStatement03 {
    public static void main(String[] args) {
        System.out.println("商品Aの金額は？");
        Scanner inputProductPriceAScanner = new Scanner(System.in);
        int ProductPriceA = Integer.parseInt(
            inputProductPriceAScanner.nextLine()
        );

        System.out.println("商品Bの金額は？");
        Scanner inputProductPriceBScanner = new Scanner(System.in);
        int ProductPriceB = Integer.parseInt(
            inputProductPriceBScanner.nextLine()
        );

        int totalPrice = ProductPriceA + ProductPriceB;

        System.out.println(
            "商品の合計は" + totalPrice + "円です。" + (
                totalPrice >= 10000 ? "贅沢ですね。" : ""
            )
        );

        inputProductPriceAScanner.close();
        inputProductPriceBScanner.close();
    }
}
