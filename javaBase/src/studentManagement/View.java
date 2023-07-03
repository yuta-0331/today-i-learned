package studentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final Scanner scan;
    private final String[] MENU_LIST = { "一覧", "検索", "追加", "修正", "削除", "保存して終了" };

    public View() {
        scan = new Scanner(System.in);
    }

    public Scanner getScan() {
        return scan;
    }

    // menu表示
    public void displayMenu() {
        System.out.println();
        for (int i = 0; i < MENU_LIST.length; i++) {
            if (i == MENU_LIST.length - 1) {
                System.out.print(":" + (i + 1) + ":" + MENU_LIST[i]);
            } else {
                System.out.print(i + 1 + ":" + MENU_LIST[i] + " ");
            }
        }
        System.out.print("\n:");
    }
    // menu選択のメソッド
    public int selectMenu() {
        displayMenu();
        //ユーザーの入力受付
        int userSelectMenu;
        while (true) {
            userSelectMenu = userInputNum();
            if (userSelectMenu >= 1 && userSelectMenu <= MENU_LIST.length) {
                if (userSelectMenu != MENU_LIST.length) {
                    System.out.println(MENU_LIST[userSelectMenu - 1] + "------");
                    ;
                }
                return userSelectMenu;
            }
            System.out.println("不正な値です");
        }
    }

    // ユーザーに文字列を入力してもらう(入力チェックあり)
    public String userInputString() {
        String inputString;
        while (true) {
            inputString = scan.nextLine();
            if (!inputString.equals("")) {
                break;
            }
            System.out.println("不正な入力です");
        }
        return inputString;
    }
    // ユーザーに文字列を入力してもらう（空文字の場合、デフォルト値を返す）
    public String userInputString(String defaultValue) {
        String inputString = scan.nextLine();
        if (inputString.equals("")) {
            inputString = defaultValue;
        }
        return inputString;
    }

    // ユーザーに数値を入力してもらう(入力チェックあり)
    public int userInputNum() {
        int inputNum;
        while (true) {
            try {
                inputNum = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("不正な入力です");
            }
        }
        return inputNum;
    }
    // ユーザーに数値を入力してもらう(空文字入力の場合、デフォルト値を返す)
    public int userInputNum(int defaultValue) {
        int inputNum;
        while (true) {
            try {
                String inputNumStr = scan.nextLine();
                if (inputNumStr.equals("")) {
                    inputNum = defaultValue;
                } else {
                    inputNum = Integer.parseInt(inputNumStr);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("不正な入力です");
            }
        }
        return inputNum;
    }
    // 引数で渡したstudentリストを表示する
    public void printList(ArrayList<Student> students) {
        for (Student student : students) {
            printList(student);
        }
    }
    // 引数で渡したstudentを表示する
    public void printList(Student student) {
        System.out.println("ID: " + student.getId() + "  " + student.getClassNum() +  "組  "
                + student.getName() + "  英語" + student.getEnglishScore() + "点  "
                + "数学" + student.getMathScore() + "点");
    }
}
