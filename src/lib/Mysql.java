package lib;

import java.sql.*;

public class Mysql {
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/form", "test", "pp00");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}