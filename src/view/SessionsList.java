package view;

import components.sessionAdapter;
import components.studentAdapter;
import dataModels.Session;
import dataModels.Student;
import listeners.absentButtonListener;
import listeners.projectButtonListener;
import model.studentModel;
import model.termsModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class SessionsList {

    private JList list;
    private JPanel panel;
    private JTextArea status;
    private ArrayList<Session> Sessions;
    private String sesionSelected;

    private JList studentsList;



    public SessionsList(ArrayList<Session> Sessions) {
        this.Sessions = Sessions;
        initComponents();
    }

    private void initComponents() {

        JFrame frame = new JFrame();
        panel = new JPanel();
        list = new JList();
        status = new JTextArea();
        status.setRows(20);
        status.setColumns(20);

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
                try {
                    jList1ValueChanged(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        studentsList = new JList();


        panel.add(list);
        panel.add(studentsList);


        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) throws SQLException {
        //set text on left here
        this.sesionSelected = (String) list.getSelectedValue();
        System.out.println("session " + this.sesionSelected);

        ArrayList<Student> students = studentModel.getStudents(
                termsModel.getId(sessionAdapter.getCurrentTerm())
        );

        System.out.println(students.size());

        studentAdapter stdList = new studentAdapter(students);

        studentsList = stdList.getStudentList();


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
