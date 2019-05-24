package view;

import dataModels.Session;
import listeners.absentButtonListener;
import listeners.projectButtonListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

public class SessionsList {

    private JList list;
    private JPanel panel;
    private JTextArea status;
    private ArrayList<Session> Sessions;
    private String sesionSelected;




    public SessionsList(ArrayList<Session> Sessions) {
        this.Sessions = Sessions;
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
                return Sessions.size();
            }

            @Override
            public Object getElementAt(int i) {
                return Sessions.get(i).getTitle();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt)
            {
                jList1ValueChanged(evt);
            }
        });



        panel.add(list);

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on left here
        this.sesionSelected = (String) list.getSelectedValue();
        System.out.println("session " + this.sesionSelected);

    }

    public static void show(ArrayList<Session> Sessions) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SessionsList(Sessions);
            }
        });
    }
}
