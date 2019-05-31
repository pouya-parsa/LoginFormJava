package model;

import dataModels.Student;
import lib.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class studentModel extends Mysql {
    public static ArrayList<Student> getStudents(int term_id) throws SQLException {
        Statement stm = connection.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM students WHERE term_id='" + term_id + "'");
        rs.first();

        ArrayList<Student> students = new ArrayList();

        do{
            students.add(new Student(rs.getInt("id"), rs.getString("name")));
        } while(rs.next());

        return students;
    }
}
