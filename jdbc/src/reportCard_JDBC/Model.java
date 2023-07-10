package reportCard_JDBC;

import java.sql.*;
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

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getStatement() {
        return statement;
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
    // レコードの追加
    public ResultSet addRecord(Grade grade) {
        String sql = "INSERT INTO grade VALUES(?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, grade.getTeam());
            statement.setString(2, grade.getName());
            statement.setInt(3, grade.getEnglishScore());
            statement.setInt(4, grade.getMathScore());
            statement.executeUpdate();
            return statement.getGeneratedKeys();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
