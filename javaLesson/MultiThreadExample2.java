class Bank {
    static int money = 0;
    static synchronized void addOneYen() {
        money++;
    }
}

class Customer implements Runnable{
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Bank.addOneYen();
        }
    }
}

public class MultiThreadExample2 {
    public static void main(String[] args) {
        Customer[] customers = new Customer[100];
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            customers[i] = new Customer();
            threads[i] = new Thread(customers[i]);
            threads[i].run();
        }

        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Bank.money);
    }
}
