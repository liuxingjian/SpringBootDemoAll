import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MockRegister {

    public static String encodePwd(String pwd) {
        return new BCryptPasswordEncoder().encode(pwd);
    }

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/userinfo?serverTimezone=GMT";
        String userName = "root";
        String pwd = "9821";
        Connection connection = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建数据库连接
            connection = DriverManager.getConnection(url, userName, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO users(username, pwd,active) VALUES (?,?,1)");
            ps.setString(1,"spring");
            ps.setString(2,encodePwd("security"));
            ps.addBatch();
            ps.setString(1,"reader");
            ps.setString(2,encodePwd("reader"));
            ps.addBatch();
            ps.executeBatch();

            ps = connection.prepareStatement("INSERT INTO userrole(username, role) VALUES (?,?)");
            ps.setString(1,"spring");
            ps.setString(2,"ROLE_admin");
            ps.addBatch();
            ps.setString(1,"reader");
            ps.setString(2,"ROLE_reader");
            ps.addBatch();
            ps.executeBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //省略关闭连接的代码
        }

    }
}
