package studentManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

// todo 例外コメントの内容を確認する
public class FunctionController {
    private int finalDigit; // 末尾のdataのid
    private ArrayList<Student> students;
    private Scanner scan;
    
    // インスタンス化時にリスト一覧を格納したStudentリストをフィールドにセット
    public FunctionController() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("reportcards.csv"), Charset.defaultCharset());
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                int id = Integer.parseInt(cols[0]);
                int classNum = Integer.parseInt(cols[1]);
                String name = cols[2];
                int englishScore = Integer.parseInt(cols[3]);
                int mathScore = Integer.parseInt(cols[4]);
                finalDigit = id;
                
                Student student = new Student(id, classNum, name, englishScore, mathScore);
                students.add(student);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("ファイル読み込みに失敗しました");
            e.printStackTrace();
        }
        this.students = students;
        scan = new Scanner(System.in);
    }
    
    //menu選択のメソッド
    public int selectMenu() {
        //menu表示
        String[] menuList = { "一覧", "検索", "追加", "修正", "削除", "保存して終了" };
        System.out.println();
        for (int i = 0; i < menuList.length; i++) {
            if (i == menuList.length - 1) {
                System.out.print(":" + (i + 1) + ":" + menuList[i]);
            } else {
                System.out.print(i + 1 + ":" + menuList[i] + " ");
            }
        }
        System.out.print("\n:");
        //ユーザーの入力受付
        int userSelectMenu;
        while (true) {
            userSelectMenu = userInputNum();
            if (userSelectMenu > menuList.length || userSelectMenu < 1) {
                System.out.println("不正な値です");
            } else {
                break;
            }
        }
        if (!menuList[userSelectMenu - 1].equals("保存して終了")) {
            System.out.println(menuList[userSelectMenu - 1] + "------");;
        }
        return userSelectMenu;
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
    
    // リスト一覧を表示する
    public void printList() {
        printList(students);
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
    
    // 名前で検索してhitした生徒をhitStudentsに格納して返す
    public ArrayList<Student> searchStudentsByName() {
        System.out.print("名前:");
        String searchName = userInputString();
        ArrayList<Student> hitStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getName().equals(searchName)) {
                hitStudents.add(student);
            }
        }
        if (hitStudents.size() == 0) {
            System.out.println("見つかりません");
        }
        return hitStudents;
    }

    // idで検索してhitした生徒をhitStudentに格納して返す
    public Student searchStudentById() {
        int searchId = userInputNum();
        Student hitStudent = null;
        for (Student student : students) {
            if (student.getId() == searchId) {
                hitStudent = student;
                break;
            }
        }
        if (hitStudent == null) {
            System.out.println("見つかりません");
        }
        return hitStudent;
    }
    
    // リストにアイテムを追加するメソッド
    public void addItem() {
        System.out.print("組:");
        int classNum = userInputNum();
        System.out.print("名前:");
        String name = userInputString();
        System.out.print("英語:");
        int englishScore = userInputNum();
        System.out.print("数学:");
        int mathScore = userInputNum();
        Student student = new Student(
                ++finalDigit, classNum, name, englishScore, mathScore
                );
        students.add(student);
        System.out.println("ID: " +student.getId() + "  " + student.getClassNum()
                +  "組  " + student.getName() + "  英語" + student.getEnglishScore() + "  "
                + "数学" + student.getMathScore() + " を追加しました。");
    }
    
    // 修正するメソッド
    public void fixItem() {
        System.out.print("ID?:");
        Student student = searchStudentById();
        if (student != null) {
            // 修正画面で空文字が入力された場合、その項目は変更しない仕様に設定
            System.out.print("クラス(" + student.getClassNum() + "):");
            int classNum = userInputNum(student.getClassNum());
            System.out.print("名前(" + student.getName() + "):");
            String name = userInputString(student.getName());
            System.out.print("英語(" + student.getEnglishScore() + "):");
            int englishScore = userInputNum(student.getEnglishScore());
            System.out.print("数学(" + student.getMathScore() + "):");
            int mathScore = userInputNum(student.getMathScore());
            // データの更新
            student.setClassNum(classNum);
            student.setName(name);
            student.setEnglishScore(englishScore);
            student.setMathScore(mathScore);
            System.out.println("編集しました");
        }
    }

    // データを削除するメソッド
    public void deleteData() {
        System.out.print("ID:");
        Student student = searchStudentById();
        if (student != null) {
            printList(student);
            System.out.println("削除しますか？(y/n):");
            String ans = scan.nextLine();
            if (ans.equals("y")) {
                students.remove(student);
                System.out.println("ID: " + student.getId() + "  を削除しました");
            }
        }
    }

    // 修正データをファイルに書き込むメソッド
    public void writeData() {
        try {
            BufferedWriter bw = Files.newBufferedWriter(
                    Paths.get("reportcards.csv"),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
                    );

            for (Student student : students) {
                bw.write(student.getId() + "," + student.getClassNum() + "," + student.getName()
                        + "," + student.getEnglishScore() + "," + student.getMathScore());
                bw.newLine();
            }
            bw.close();
            System.out.println("保存しました。終了。");
        } catch (IOException e) {
            System.out.println("保存に失敗しました");
            e.printStackTrace();
        }
    }

    public void executeFunction() {
        FunctionLoop: do {
            int userSelectMenu = selectMenu();
            switch (userSelectMenu) {
                case 1:
                    printList();
                    break;
                case 2:
                    printList(searchStudentsByName());
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    fixItem();
                    break;
                case 5:
                    deleteData();
                    break;
                case 6:
                    writeData();
                    scan.close();
                    break FunctionLoop;
            }
        } while (true);
    }
}
