package components;

import dataModels.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class studentAdapter extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    private static ArrayList<Student> studentsList;

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


        studentList.setCellRenderer(new studentItemRenderer(studentListModel));


        JFrame frame = new JFrame("Sizing Samples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(studentList);


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
