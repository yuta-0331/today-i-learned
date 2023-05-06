import java.util.Scanner;

public class IfStatement {

    public static void main(String[] args) {
        
        System.out.println("name ?");
        Scanner inputName = new Scanner(System.in);
        String nameString = inputName.nextLine();

        System.out.println("age ?");
        Scanner inputAge = new Scanner(System.in);
        int age = inputAge.nextInt();

        if (age >= 18) {
            System.out.println(nameString + "さんは大人です");
        } else {
            System.out.println(inputName + "さんは子供です");
        }

        inputAge.close();
        inputName.close();
    }
}