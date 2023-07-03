public class FibonacciNumber {
    public static int createFibNum(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("引数は正の整数である必要があります");
        }
        
        if (num == 1 || num == 2) {
            return num - 1;
        }
        
        int prev = 0;
        int current = 1;
        
        for (int i = 3; i <= num; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        
        return current;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println(createFibNum(i));
        }
    }
}

