package lesson;

class InvalidNumberException extends Exception {
	InvalidNumberException(String msg) {
		super(msg);
	}
}
public class GuessTheNumber {
	
	public static int inputNumber(int min, int max) {
		while (true) {
			try {
				int inputNum = Integer.parseInt(MyConsole.readLine());
				if (inputNum <= min || inputNum > max) {
					throw new InvalidNumberException(min + "より大きく" + max + "以下の数値で入力してください");
				}
				return inputNum;
	  		} catch (InvalidNumberException e) {
	  			System.out.println(e.getMessage());
	  		} catch (NumberFormatException e){
	  			System.out.println(e + ": 数値で入力してください");
	  		}
		}
	}

	public static void main(String[] args) {
		System.out.println("所持金を入力してください");
		int initMoney = inputNumber(0, 2147483647 );
		System.out.println("金:" + initMoney);
		
		GameLoop: while (true) {
			System.out.print("いくらかけますか?: ");
			int wager = inputNumber(0, initMoney);
			
			System.out.print("何番にかけますか?: ");
			int userNum = inputNumber(0, 6);
			
			int randomNum = (int) (Math.random() * 6 + 1);
			if (userNum == randomNum) {
				System.out.println("あたり！");
				initMoney += wager * 5;
			} else {
				System.out.println("はずれ！");
				initMoney -= wager;
			}
			System.out.println("金:" + initMoney);
			if (initMoney == 0) {
				System.out.println("所持金がなくなりました。");
				System.out.println("GAME OVER");
				break;
			}
			System.out.println("ゲームを続けますか？");
			String ans;
			AnsLoop: while (true) {
				ans = MyConsole.readLine();
				switch (ans) {
				case "y":
					break AnsLoop;
				case "n":
					break GameLoop;
				default:
					System.out.println("y/n で答えてください");
					break;
				}
			}
		}
	System.out.println("ゲームが終了しました");
	System.out.println("所持金は" + initMoney);
	}

}
