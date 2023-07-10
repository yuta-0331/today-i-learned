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
    public void displayMenu() {
        view.displayList(model.getList());
    }

    // 機能2: レコードの検索
    public void displaySearchRecord() {
        System.out.print("名前:");
        view.displayList(model.getSearchResults(view.inputStr()));
    }

    // 機能3: レコードの追加
    public void addRecord() {
        Grade grade = view.createNewGrade();
        try {
            ResultSet resultSet = model.addRecord(grade);
            if (resultSet.next()) {
                view.displayRecordForAddOrDelete(
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

    public void executeFunction() {
        while (true) {
            view.displayMenu();

            switch (view.selectMenu()) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    displaySearchRecord();
                    break;
                case 3:
                    addRecord();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    try {
                        model.getConnection().close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("正常に終了できませんでした");
                    }
            }
        }


    }

}
