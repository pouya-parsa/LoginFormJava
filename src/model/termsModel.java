package model;

import dataModels.Term;
import lib.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class termsModel extends Mysql {

    private static final String TABLE_NAME = "terms";

    private  static ArrayList<Term> Terms = new ArrayList();

    public static ArrayList<Term> getTerm() throws SQLException {
        Statement stm = connection.createStatement();

        ResultSet resultSet = stm.executeQuery("SELECT * FROM " + TABLE_NAME);

        resultSet.first();

        do  {
            Terms.add(
                    new Term(resultSet.getString("term_title"), resultSet.getInt("id")));
        }
        while(resultSet.next());

        return Terms;
    }
}
