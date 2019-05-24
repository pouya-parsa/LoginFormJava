package components;

import model.sessionsModel;
import view.SessionsList;

import java.sql.SQLException;

public class sessionAdapter {
    public static void getSessions(int term_id) throws SQLException {
        SessionsList.show(sessionsModel.getSession(term_id));
    }
}
