package reportCard_JDBC;

import java.sql.ResultSet;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    // 機能1: リスト表示
    public void displayList() {
        view.displayList(model.getList());
    }

    // 機能2: レコードの検索
    public void displaySearchRecord() {
        System.out.print("名前:");
        view.displayList(model.getSearchResultsByName(view.inputStr()));
    }

    // 機能3: レコードの追加
    public void addRecord() {
        Grade grade = view.createNewGrade();
        try {
            ResultSet resultSet = model.addRecord(grade);
            if (resultSet == null) {
                System.out.println("追加できませんでした");
            } else if (resultSet.next()) {
                view.displayRecord(
                        new Grade(resultSet.getInt(1),
                                grade.getTeam(),
                                grade.getName(),
                                grade.getEnglishScore(),
                                grade.getMathScore())
                );
            } else {
                System.out.println("追加に失敗しました");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 機能4 レコードの編集
    public void editRecord() {
        int id = view.selectRecordById();
        Grade grade = model.getSearchResultsById(id);
        if (grade == null) {
            System.out.println("レコードが見つかりませんでした");
            return;
        }
        int rows = model.editRecord(view.editRecord(grade));
        String msg;
        if (rows != 0) {
            msg = "編集しました";
        } else {
            msg = "編集に失敗しました";
        }
        System.out.println(msg);
    }
    
    // 機能5 レコードの削除
    public void deleteRecord() {
        int id = view.selectRecordById();
        Grade grade = model.getSearchResultsById(id);
        if (grade == null) {
            System.out.println("レコードが見つかりませんでした");
            return;
        }
        if (view.selectDeleteConfirm(grade)) {
            int rows = model.deleteRecord(id);
            if (rows != 0) {
                System.out.println("ID:" + id + " を削除しました");
            } else {
                System.out.println("削除に失敗しました");
            }
            
        } else {
            System.out.println("削除をキャンセルしました");
        }
    }

    public void executeFunction() {
        FunctionLoop: while (true) {
            view.displayMenu();

            switch (view.selectMenu()) {
                case 1:
                    displayList();
                    break;
                case 2:
                    displaySearchRecord();
                    break;
                case 3:
                    addRecord();
                    break;
                case 4:
                    editRecord();
                    break;
                case 5:
                    deleteRecord();
                    break;
                case 6:
                    try {
                        model.getConnection().close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("正常に終了できませんでした");
                    }
                    view.getScanner().close();
                    break FunctionLoop;
            }
        }
    }

}
