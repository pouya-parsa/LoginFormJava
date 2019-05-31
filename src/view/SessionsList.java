package view;

import components.sessionAdapter;
import components.studentAdapter;
import components.termsAdapter;
import dataModels.Session;
import dataModels.Student;
import listeners.absentButtonListener;
import listeners.projectButtonListener;
import model.sessionsModel;
import model.studentModel;
import model.termsModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
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

        list.setPreferredSize(new Dimension(200, 400));
        list.setBorder(new EmptyBorder(50, 0, 100, 0));
        list.setFixedCellHeight(40);
        list.setFixedCellWidth(100);
        list.setSelectionBackground(new Color(38, 139, 69));
        list.setSelectionForeground(Color.white);


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
        sessionAdapter.setCurrentSession(sessionsModel.getId(this.sesionSelected));
        System.out.println("session " + this.sesionSelected);

        ArrayList<Student> students = studentModel.getStudents(
                termsAdapter.getCurrentTerm()
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
