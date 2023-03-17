import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqltest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","9821");

    }


}
