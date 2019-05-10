import java.sql.*;
import java.util.HashMap;

class MysqlCon {
    Connection con;
    public MysqlCon() throws ClassNotFoundException, SQLException {

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/form", "test", "pp00");



    }

    public HashMap<String, String > canLoginWith(String username, String password) throws SQLException {

        HashMap<String, String> user = new HashMap<>();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select * from users where username='"+username+ "' and password='"+password+"'");

        int count = 0;

        while (rs.next()) {
            count++;
        }

        if(count != 0) {
            rs.first();
            user.put("name", rs.getString(rs.findColumn("username")));
            user.put("status", "success");
        } else {
            user.put("status", "failed");
        }

        con.close();
        return user;

    }

    public void signUpWith(String username, String password) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("insert into users (username, password) VALUES ('"+username+ "','"+password+"')");
        stmt.execute();
    }
}