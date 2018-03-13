import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/will";
        String userName = "me";
        String password = "2b172b";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("update A set age=? where id=?");
            preparedStatement.setInt(1,22);
            preparedStatement.setInt(2,2);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
