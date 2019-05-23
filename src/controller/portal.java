package controller;

import components.termsAdapter;
import dataModels.Term;

import java.sql.SQLException;
import java.util.ArrayList;

public class portal {
    static {
        try {
            ArrayList<Term> a = termsAdapter.getTerms();

//            for(Term term : a) {
//                System.out.println(term.getTitle());
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void start() {
        System.out.println("Start");
    }
}
