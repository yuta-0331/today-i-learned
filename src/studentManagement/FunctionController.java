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
// todo 例外コメントの内容確認する
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
            e.printStackTrace();
        }
        this.students = students;
        scan = new Scanner(System.in);
    }
    
    public Scanner getScan() {
        return scan;
    }
    
    //menu選択のメソッド
    public int selectMenu() {
        //menu表示
        String[] menuList = { "一覧", "検索", "追加", "修正", "削除", "保存して終了" };
        for (int i = 0; i < menuList.length; i++) {
            System.out.print(i + 1 + menuList[i] + " ");
        }
        System.out.print("\n:");
        //ユーザーの入力受付
        int userSelectMenu;
        while (true) {
            userSelectMenu = userInputNum();
            if (userSelectMenu > 6 || userSelectMenu <1) {
                System.out.println("不正な値です");
            } else {
                break;
            }
        }
        System.out.println(menuList[userSelectMenu - 1] + "------");
        return userSelectMenu;
    }

    // ユーザーに文字列を入力してもらう
    public String userInputString() {
        String inputString;
        while (true) {
            inputString = scan.nextLine();
            if (!inputString.equals("")) {
                System.out.println("不正な入力です");
                break;
            }
        }
        return inputString;
    }

    // ユーザーに数値を入力してもらう
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
    
    // リスト一覧を表示する
    public void printList() {
        printList(students);
    }
    // 引数で渡したstudentリストを表示する
    public void printList(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + "  " + student.getClassNum() +  "組  "
                    + student.getName() + "  英語" + student.getEnglishScore() + "点  "
                    + "数学" + student.getMathScore() + "点");
        }
    }
    
    // 検索してhitした生徒をhitStudentsに格納して返す
    public ArrayList<Student> searchStudents() {
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
    
    // リストにアイテムを追加するメソッド
    public void addStudent() {
        System.out.print("組:");
        int classNum = userInputNum();
        System.out.print("名前:");
        String name = userInputString();
        System.out.print("英語:");
        int englishScore = userInputNum();
        System.out.print("数学:");
        int mathScore = userInputNum();
        Student student = new Student(
                finalDigit + 1, classNum, name, englishScore, mathScore
                );
        students.add(student);
        finalDigit++; // 末尾のidをインクリメント
        System.out.println("ID: " +student.getId() + "  " + student.getClassNum()
                +  "組  " + student.getName() + "  英語" + student.getEnglishScore() + "  "
                + "数学" + student.getMathScore() + " を追加しました。");
    }
    
    // 修正するメソッド
    public void fixItem() {
        System.out.print("ID?:");
        int inputId = userInputNum();
        // 入力されたidと照合して一致するものがあればfixStudentに格納
        Student fixStudent = null;
        for (Student student : students) {
            if (student.getId() == inputId) {
                fixStudent = student;
                System.out.print("クラス(" + student.getClassNum() + "):");
                int classNum = userInputNum();
                System.out.print("名前(" + student.getName() + "):");
                String name = userInputString();
                System.out.print("英語(" + student.getEnglishScore() + "):");
                int mathScore = userInputNum();
                System.out.print("数学(" + student.getMathScore() + "):");
                int englishScore = userInputNum();
                // データの更新
                fixStudent.setClassNum(classNum);
                fixStudent.setName(name);
                fixStudent.setEnglishScore(englishScore);
                fixStudent.setMathScore(mathScore);
                System.out.println("編集しました");
                break;
            }
        }
        if (fixStudent == null) {
            System.out.println("見つかりません");
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
        } catch (IOException e) {
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
                    printList(searchStudents());
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    fixItem();
                    break;
                case 5:
                    break;
                case 6:
                    writeData();
                    break FunctionLoop;
            }
        } while (true);
    }
}
