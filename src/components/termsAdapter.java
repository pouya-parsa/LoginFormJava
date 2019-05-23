package components;

import dataModels.Term;
import model.termsModel;
import view.TermsList;

import java.sql.SQLException;
import java.util.ArrayList;

public class termsAdapter {

   public static ArrayList<Term> getTerms() throws SQLException {
        TermsList.show(termsModel.getTerm());
        return null;
    }

}
