public class MyDouble02 {
    public static void main(String[] args) {
        int count = 0;
        boolean isContinue = true;

        while (isContinue) {
            System.out.print("数値を入力してください:");
            String inputNumber = MyConsole.readLine();

            if (inputNumber.equals("")) {
                isContinue = false;
                break;
            } else {
                int num = Integer.parseInt(inputNumber);
                if (num >= 10){
                    count++;
                }
            }
        }
        System.out.println("10以上の値は" + count + "回");
    }
}
