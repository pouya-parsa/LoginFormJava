package listeners;

import components.sessionAdapter;
import model.termsModel;
import view.SessionsList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class absentButtonListener implements ActionListener {

    String term = "";

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.print("absent button is clicked : " + this.term + " with id ");
        try {
            System.out.println(termsModel.getId(this.term));
            sessionAdapter.getSessions(
                    termsModel.getId(this.term));

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
