package controller;

import components.termsAdapter;
import java.sql.SQLException;

public class portal {

    public static void start() throws SQLException {
        System.out.println("Start");
        showTerms();
    }

    public static void showTerms() throws SQLException {
        termsAdapter.getTerms();
    }
}
