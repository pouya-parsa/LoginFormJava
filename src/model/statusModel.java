package model;

import lib.Mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class statusModel extends Mysql {
    public static void create(int term_id, int session_id, int std_id, boolean status) throws SQLException {


        PreparedStatement stmt = connection.prepareStatement("INSERT INTO status (term_id, session_id, student_id, status) VALUES ( '" + term_id + "', '"+ session_id +"', '"+ std_id +"', "+ status +") ");
        stmt.execute();
    }

    public static boolean getStatus(int term_id, int session_id, int std_id) throws SQLException {
        Statement stm = connection.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM status WHERE term_id='" + term_id + "' AND session_id='"+ session_id +"' AND student_id='"+ std_id +"'");

        if(rs == null) {
            return false;
        }else {

            rs.last();

            return rs.getBoolean("status");
        }
    }
}
