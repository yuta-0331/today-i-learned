package reportCard_JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final String[] MENU_LIST = { "一覧", "検索", "追加", "修正", "削除", "終了" };
    private final Scanner scanner;
    private int choiceMenuNum;
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
            choiceMenuNum = inputNum();
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
        if (gradeList.size() == 0) {
            System.out.println("データが見つかりません");
            return;
        }
        for (Grade grade : gradeList) {
            displayRecord(grade);
            System.out.println();
        }
    }
    // gradeインスタンスの表示
    public void displayRecord(Grade grade) {
        System.out.print("ID: " + grade.getId() + "  " + grade.getTeam() + "組  "
                + grade.getName() + "  英語" + grade.getEnglishScore() + "点  数学"
                + grade.getMathScore() + "点　");
    }

    // 削除、追加の確認表示
    public void displayRecordForAddOrDelete(Grade grade) {
        String msg = null;
        if (choiceMenuNum == 3) {
            msg = "を追加しました。";
        } else if (choiceMenuNum == 5) {
            msg = "\n削除しますか？(y/n):";
        }
        displayRecord(grade);
        System.out.println(msg);
    }

    // レコードの追加に使用するGrade型変数を作成
    // *todo:点数の入力チェックを入れる
    public Grade createNewGrade() {
        System.out.print("組:");
        String team = inputStr();
        System.out.print("名前:");
        String name = inputStr();
        System.out.print("英語:");
        int englishScore = inputNum();
        System.out.print("数学:");
        int mathScore = inputNum();
        // 仮にid = 0 でGradeインスタンスを作成
        return new Grade(0, team, name, englishScore, mathScore);
    }
}
