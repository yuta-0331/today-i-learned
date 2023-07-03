public class RockPaperScissors {
    public static void main(String[] args) {
        String[] gameCommands = { "ぐー", "ちょき", "ぱー" };

        System.out.println("じゃんけん");
        while (true) {
            int randomCommand = (int) (Math.random() * 3);
            int userCommand = Integer.parseInt(MyConsole.readLine());

            System.out.println("ぽん！");
            System.out.println("user:" + gameCommands[userCommand]);
            System.out.println("CPU:" + gameCommands[randomCommand]);

            if (userCommand == randomCommand) {
                System.out.println("あいこで");
                continue;
            }

            String winMsg = "あなたの勝ち", loseMsg = "あなたの負け";
            if (userCommand == 0) {
                System.out.println(randomCommand == 1 ? winMsg : loseMsg);
                break;
            } else if (userCommand == 1) {
                System.out.println(randomCommand == 2 ? winMsg : loseMsg);
                break;
            } else {
                System.out.println(randomCommand == 0 ? winMsg : loseMsg);
                break;
            }
        }
    }
}
