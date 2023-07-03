import java.util.Scanner;

public class PrimeNumber {
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("正の整数を入力してください");
        Scanner numScanner = new Scanner(System.in);
        int num = numScanner.nextInt();
        numScanner.close();

        System.out.println(num + "までの素数:");
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}

