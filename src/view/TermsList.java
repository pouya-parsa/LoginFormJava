package view;

import dataModels.Term;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class TermsList {

    private JList list;
    private JPanel panel;
    private JTextArea status;
    private ArrayList<Term> Terms;


    public TermsList(ArrayList<Term> Terms) {
        this.Terms = Terms;
        initComponents();
    }

    private void initComponents() {

        JFrame frame = new JFrame();
        panel = new JPanel();
        list = new JList();
        status = new JTextArea();

        list.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return Terms.size();
            }

            @Override
            public Object getElementAt(int i) {
                return Terms.get(i).getTitle();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });

        status.setColumns(20);
        status.setRows(5);

        panel.add(list);
        panel.add(status);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) list.getSelectedValue();
        status.setText(s);
    }

    public static void show(ArrayList<Term> Terms) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TermsList(Terms);
            }
        });
    }
}
