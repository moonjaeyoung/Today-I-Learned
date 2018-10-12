import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-11 오전 3:40
 * @Homepage : https://github.com/gusdnd852
 */

public class PreStatement {
    static {
        try {
            Class.forName(SQL.DRIVER);
        } catch (ClassNotFoundException ignore) {
        }
    }
    public static void main(String[] args) {
        //PreparedStatement를 사용하면 많은 데이터를 insert 해야할때 훨씬 직관적이게끔 할 수 있음.
        try (Connection connection = DriverManager.getConnection(SQL.URL, SQL.ID, SQL.PW);
             PreparedStatement statement = connection.prepareStatement("insert into MEMBER(ID,PW,AGE,NAME) values (?,?,?,?)")
        ) {
            statement.setString(1, "woong");
            statement.setString(2, "123");
            statement.setInt(3, 20);
            statement.setString(4, "Woong");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
