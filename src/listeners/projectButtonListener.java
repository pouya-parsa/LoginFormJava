package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class projectButtonListener implements ActionListener {
    String term = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("project button is clicked : " + this.term);
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
