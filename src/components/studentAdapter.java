package components;

import dataModels.Student;
import model.statusModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentAdapter extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    private static ArrayList<Student> studentsList;

    private JButton submitButton;

    DefaultListModel studentListModel;

    private JList studentList;

    public studentAdapter(ArrayList<Student> students) {
        this.studentsList = students;

        this.studentListModel = new DefaultListModel();

        studentListModel.clear();

        for(Student student: students) {
            studentListModel.addElement(student);
        }

        studentList = new JList(studentListModel);
        studentList.setBorder(new EmptyBorder(50, 0, 100, 0));

        studentList.setFixedCellHeight(40);
        studentList.setFixedCellWidth(200);

        studentList.setCellRenderer(new studentItemRenderer(studentListModel));

        submitButton = new JButton("submit");
        submitButton.setBounds(20, 20, 100, 50);

        JPanel panel = new JPanel();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < studentListModel.size(); i++) {
                    Student std = (Student) studentListModel.get(i);

                    System.out.println(termsAdapter.getCurrentTerm() + " : " + sessionAdapter.getCurrentSession() + " : "+ std.getId() + " : " + std.isChecked());
                    try {
                        statusModel.create(termsAdapter.getCurrentTerm(), sessionAdapter.getCurrentSession(), std.getId(), std.isChecked());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JFrame frame = new JFrame("Absent List");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        panel.add(studentList);
        panel.add(submitButton);


        frame.add(panel);


        frame.setSize(300, 350);
        frame.setVisible(true);


    }

    public JList getStudentList() {
        return studentList;
    }

    public void setStudentList(JList studentList) {
        this.studentList = studentList;
    }

    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public static void setStudentsList(ArrayList<Student> studentsList) {
        studentAdapter.studentsList = studentsList;
    }
}
