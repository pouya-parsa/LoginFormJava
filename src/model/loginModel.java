package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import lib.Mysql;

public class loginModel extends Mysql {

    private static final String TABLE_NAME = "students";

    public loginModel() throws SQLException {

    }

    public static HashMap<String, String > canLoginWith(String username, String password) throws SQLException {

        HashMap<String, String> user = new HashMap<>();

        Statement stmt = connection.createStatement();



        ResultSet rs = stmt.executeQuery("select * from " + TABLE_NAME +
                " where username='" + username + "' and password='" + password + "'");

        System.out.println("select * from " + TABLE_NAME +
                " where username='" + username + "' and password ='" + password + "'");

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

        return user;

    }

    public static void signUpWith(String username, String password) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("insert into " + TABLE_NAME + " (username, password, name) VALUES ('"+username+ "','"+password+"', 'a')");
        stmt.execute();
    }
}
