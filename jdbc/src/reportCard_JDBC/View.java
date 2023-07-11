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
    
    public Scanner getScanner() {
        return scanner;
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
    // スコアの入力
    public int inputScore() {
        int num;
        while (true) {
            num = inputNum();
            if (num >= 0) {
                break;
            } else {
                System.out.println("不正な入力です");
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
        if (MENU_LIST[choiceMenuNum - 1].equals("追加")) {
            System.out.println("を追加しました。");
        } 
    }

    // レコードの追加に使用するGrade型変数を作成
    public Grade createNewGrade() {
        System.out.print("組:");
        String team = inputStr();
        System.out.print("名前:");
        String name = inputStr();
        System.out.print("英語:");
        int englishScore = inputScore();
        System.out.print("数学:");
        int mathScore = inputScore();
        // 仮にid = 0 でGradeインスタンスを作成
        return new Grade(0, team, name, englishScore, mathScore);
    }
    
    // レコードの修正内容をGradeインスタンスで返す (beforeCorrection: 修正前の)
    public Grade editRecord(Grade gradeBeforeCorrection) {
        System.out.print("クラス(" + gradeBeforeCorrection.getTeam() + "):");
        String team = inputStr();
        System.out.print("名前(" + gradeBeforeCorrection.getName() + "):");
        String name = inputStr();
        System.out.print("英語(" + gradeBeforeCorrection.getEnglishScore() + "):");
        int englishScore = inputScore();
        System.out.print("数学(" + gradeBeforeCorrection.getMathScore() + "):");
        int mathScore = inputScore();
        
        return new Grade(gradeBeforeCorrection.getId(), team, name, englishScore, mathScore);
    }
    
    // レコードidの指定
    public int selectRecordById() {
        System.out.println("ID:");
        return inputNum();
    }
    // 削除の確認
    public boolean selectDeleteConfirm(Grade grade) {
        displayRecord(grade);
        System.out.println("削除しますか？(y/n)");
        while (true) {
            String ans = inputStr();
            if (ans.equals("y")) {
                return true;
            } else if (ans.equals("n")) {
                return false;
            } else {
                System.out.println("y/nで選択してください");
            }
        }
        
    }
}
