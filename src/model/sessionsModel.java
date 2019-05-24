package model;

import dataModels.Session;
import lib.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sessionsModel  extends Mysql {
    public static ArrayList<Session> getSession(int term_id) throws SQLException {
        Statement stm = connection.createStatement();

        ResultSet rs = stm.executeQuery("SELECT  * FROM sessions WHERE term_id = '" + term_id + "'");
        rs.first();

        ArrayList<Session> sessions = new ArrayList<>();

        do {
            sessions.add(new Session(rs.getString("title")));
        } while (rs.next());

        return sessions;
    }
}
