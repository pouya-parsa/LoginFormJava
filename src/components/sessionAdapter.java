package components;

import model.sessionsModel;
import view.SessionsList;

import java.sql.SQLException;

public class sessionAdapter {


    private static String CurrentTerm;

    public static void getSessions(int term_id) throws SQLException {
        SessionsList.show(sessionsModel.getSession(term_id));
    }

    public static String getCurrentTerm() {
        return CurrentTerm;
    }

    public static void setCurrentTerm(String currentTerm) {
        CurrentTerm = currentTerm;
    }
}
