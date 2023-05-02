import java.util.Scanner;

public class MyIfStatement {
    public static void main(String[] args) {
        System.out.println("商品を入力してください");
        Scanner inputProductName = new Scanner(System.in);
        String productName = inputProductName.nextLine();
        Integer price = null;

        if (productName.equals("けしごむ")) {
            price = 200; 
        } else {
            price = null;
        }

        if(price != null) {
            System.out.println(productName + " is " + price);
        } else {
            System.out.println("product is not found");
        }
    }
}
