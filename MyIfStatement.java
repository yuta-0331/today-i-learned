import java.util.Scanner;

public class MyIfStatement {
    public static void main(String[] args) {
        System.out.println("商品を入力してください");
        Scanner inputProductName = new Scanner(System.in);
        String productName = inputProductName.nextLine();
        Integer price = null;

        if (productName.equals("えんぴつ")) {
            price = 50; 
        } else if (productName.equals("消しゴム")) {
            price = 100;
        } else if (productName.equals("定規")) {
            price = 200;
        }

        if(price != null) {
            System.out.println(productName + "は" + price + "円です。");
        } else {
            System.out.println("商品が見つかりません");
        }

        inputProductName.close();
    }
}
