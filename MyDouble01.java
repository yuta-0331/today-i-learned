public class MyDouble01 {
    public static void main(String[] args) {
        boolean isContinue = true;
        int count = 1;
        int total = 0;

        while (isContinue) {
            System.out.println(count + "回目:");
            int inputNumber = Integer.parseInt(MyConsole.readLine());
            total += inputNumber;

            while (true) {
                System.out.println("続けますか？y or n");
                String ans = MyConsole.readLine();
                if (ans.equals("n")) {
                    isContinue = false;
                    break;
                } else if (ans.equals("y")) {
                    count++;
                    break;
                } else {
                    System.out.println("n or yで答えてください");
                }
            }
        }
        double average = (double)total / count;
        System.out.println("Average: " + average + "です。");
    }
}
