package studentManagement;

import java.util.ArrayList;

// todo 例外コメントの内容を確認する
public class FunctionController {
    private int finalDigit; // 末尾のdataのid
    private ArrayList<Student> students;
    private View view;
    private Model model;

    // インスタンス化時にリスト一覧を格納したStudentリストをフィールドにセット
    public FunctionController() {
        model = new Model();
        this.students = model.readFile();
        view = new View();
        finalDigit = model.getFinalDigit();
    }
    
    // 名前で検索してhitした生徒をhitStudentsに格納して返す
    public ArrayList<Student> searchStudentsByName() {
        System.out.print("名前:");
        String searchName = view.userInputString();
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
        int searchId = view.userInputNum();
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
        int classNum = view.userInputNum();
        System.out.print("名前:");
        String name = view.userInputString();
        System.out.print("英語:");
        int englishScore = view.userInputNum();
        System.out.print("数学:");
        int mathScore = view.userInputNum();
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
            int classNum = view.userInputNum(student.getClassNum());
            System.out.print("名前(" + student.getName() + "):");
            String name = view.userInputString(student.getName());
            System.out.print("英語(" + student.getEnglishScore() + "):");
            int englishScore = view.userInputNum(student.getEnglishScore());
            System.out.print("数学(" + student.getMathScore() + "):");
            int mathScore = view.userInputNum(student.getMathScore());
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
            view.printList(student);
            System.out.println("削除しますか？(y/n):");
            String ans = view.getScan().nextLine();
            if (ans.equals("y")) {
                students.remove(student);
                System.out.println("ID: " + student.getId() + "  を削除しました");
            }
        }
    }

    public void executeFunction() {
        FunctionLoop: do {
            int userSelectMenu = view.selectMenu();
            switch (userSelectMenu) {
                case 1:
                    view.printList(students);
                    break;
                case 2:
                    view.printList(searchStudentsByName());
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
                    model.writeData(students);
                    view.getScan().close();
                    break FunctionLoop;
            }
        } while (true);
    }
}
