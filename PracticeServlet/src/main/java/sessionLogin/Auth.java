package sessionLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Auth {
    boolean isAuth(String userName, String pw) {
        boolean isAuth = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=ReportCard;"
                    + "encrypt=true;trustServerCertificate=true;"
                    + "integratedSecurity=false;user=sa;password=Password.1;");

            String sql = "SELECT * FROM ユーザー WHERE userName = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, pw);

            ResultSet resultSet = statement.executeQuery();
            isAuth = resultSet.next();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAuth;
    }
}
