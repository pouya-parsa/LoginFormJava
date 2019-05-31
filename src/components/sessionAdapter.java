package components;

import model.sessionsModel;
import view.SessionsList;

import java.sql.SQLException;

public class sessionAdapter {


    private static int CurrentSession;

    public static void getSessions(int term_id) throws SQLException {
        SessionsList.show(sessionsModel.getSession(term_id));
    }

    public static int getCurrentSession() {
        return CurrentSession;
    }

    public static void setCurrentSession(int currentSession) {
        CurrentSession = currentSession;
    }
}
