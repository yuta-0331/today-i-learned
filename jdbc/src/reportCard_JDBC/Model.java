package reportCard_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model {
    private Connection connection;
    private PreparedStatement statement;
    
    public Model() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = 
                    DriverManager.getConnection("jdbc:sqlserver://localhost;database=ReportCard;"
                            + "encrypt=true;trustServerCertificate=true;"
                            + "integratedSecurity=false;user=sa;password=Password.1;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // リストの取得
    public ArrayList<Grade> getList() {
        String sql = "SELECT * FROM grade";
        ArrayList<Grade> gradeList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                gradeList.add(
                        new Grade(
                                resultSet.getInt("id"), 
                                resultSet.getString("team"),
                                resultSet.getString("name"),
                                resultSet.getInt("englishScore"),
                                resultSet.getInt("mathScore") ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;
    }
    // 検索してhitした生徒を表示
    public ArrayList<Grade> getSearchResults(String name) {
        String sql = "SELECT * FROM grade WHERE name = ?";
        ArrayList<Grade> gradeList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                gradeList.add(new Grade(
                        resultSet.getInt("id"),
                        resultSet.getString("team"),
                        resultSet.getString("name"),
                        resultSet.getInt("englishScore"),
                        resultSet.getInt("mathScore")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;
    }

    public Integer addRecord(String team, String name, int englishScore, int mathScore) {
        String sql = "INSERT INTO grade VALUES(?, ?, ?, ?)";
        int rows;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, team);
            statement.setString(2, name);
            statement.setInt(3, englishScore);
            statement.setInt(4, mathScore);
            rows = statement.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
