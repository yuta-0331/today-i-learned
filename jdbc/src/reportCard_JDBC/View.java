package reportCard_JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final String[] MENU_LIST = { "一覧", "検索", "追加", "修正", "削除" };
    private final Scanner scanner;
    
    public View() {
        scanner = new Scanner(System.in);
    }

    // menu表示
    public void displayMenu() {
        System.out.println();
        for (int i = 0; i < MENU_LIST.length; i++) {
            System.out.print(i + 1 + ":" + MENU_LIST[i] + " ");
        }
        System.out.println();
    }
    // menu選択
    public int selectMenu() {
        while (true) {
            System.out.print(":");
            int choiceMenuNum = inputNum();
            if (choiceMenuNum >= 1 && choiceMenuNum <= MENU_LIST.length) {
                System.out.println(MENU_LIST[choiceMenuNum - 1] + "------");
                return choiceMenuNum;
            } else {
                System.out.println("1~" + MENU_LIST.length + "で入力してください");
            }
        }
    }
    // 数値の入力
    public int inputNum() {
        int num;
        while (true) {
            try {
                String inputNum = scanner.nextLine();
                if (inputNum.equals("")) {
                    System.out.println("数値で入力してください");
                    continue;
                }
                num = Integer.parseInt(inputNum);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return num;
    }
    // 文字列の入力
    public String inputStr() {
        String str;
        while (true) {
            try {
                str = scanner.nextLine();
                if (str.equals("")) {
                    System.out.println("不正な入力です");
                    continue;
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    // リストの表示
    public void displayList(ArrayList<Grade> gradeList) {
        for (Grade grade : gradeList) {
            System.out.println("ID: " + grade.getId() + "  " + grade.getTeam() + "組  "
                    + grade.getName() + "  英語" + grade.getEnglishScore() + "点  数学" 
                    + grade.getMathScore() + "点");
        }
    }

    // レコードの追加
    public Grade addRecordCreate() {
        System.out.println("組:");
        String team = inputStr();
        System.out.println("名前:");
        String name = inputStr();
        System.out.println("英語:");
        int englishScore = inputNum();
        System.out.println("数学:");
        int mathScore = inputNum();
        return new Grade(0, team, name, englishScore, mathScore);

    }
}
