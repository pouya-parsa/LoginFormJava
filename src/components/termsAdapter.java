package components;

import dataModels.Term;
import model.termsModel;
import view.TermsList;

import java.sql.SQLException;
import java.util.ArrayList;

public class termsAdapter {

    private static int currentTerm;

   public static ArrayList<Term>     getTerms() throws SQLException {
        TermsList.show(termsModel.getTerm());
        return null;
    }

    public static int getCurrentTerm() {
        return currentTerm;
    }

    public static void setCurrentTerm(int currentTerm) {
        termsAdapter.currentTerm = currentTerm;
    }
}
