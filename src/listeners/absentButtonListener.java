package listeners;

import components.sessionAdapter;
import components.termsAdapter;
import model.termsModel;
import view.SessionsList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class absentButtonListener implements ActionListener {

    String term;

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.print("absent button is clicked : " + this.term + " with id ");
        try {
            System.out.println(termsModel.getId(this.term));
            sessionAdapter.getSessions(
                    termsAdapter.getCurrentTerm());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
