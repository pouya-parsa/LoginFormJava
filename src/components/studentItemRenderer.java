package components;

import dataModels.Student;

import javax.swing.*;
import java.awt.*;

public class studentItemRenderer extends JCheckBox implements ListCellRenderer<Object> {


    DefaultListModel studentListModel;
    public studentItemRenderer(DefaultListModel studentListModel) {
        this.studentListModel = studentListModel;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Student student = (Student) value;

        JCheckBox checkBox = new JCheckBox(student.getName());
        checkBox.setBounds(100,100, 50,50);


        if(isSelected) {
            student.setChecked(true);
            System.out.println("hello");
            studentListModel.set(index, student);
        }

        if(student.isChecked()) {
            checkBox.setSelected(true);
        }

        return checkBox;
    }

}
