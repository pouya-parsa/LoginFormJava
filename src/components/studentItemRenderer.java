package components;

import dataModels.Student;
import model.statusModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class studentItemRenderer extends JCheckBox implements ListCellRenderer<Object> {


    DefaultListModel studentListModel;
    public studentItemRenderer(DefaultListModel studentListModel) {
        this.studentListModel = studentListModel;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Student student = (Student) value;

        JCheckBox checkBox = new JCheckBox(student.getName());
        try {
            if(statusModel.getStatus(termsAdapter.getCurrentTerm(), sessionAdapter.getCurrentSession(), student.getId()))
                checkBox.setSelected(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        checkBox.setBounds(100,100, 50,50);


        if(isSelected) {
            student.setChecked(true);
            studentListModel.set(index, student);
        }

        if(student.isChecked()) {
            checkBox.setSelected(true);
        }

        checkBox.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0,Color.BLACK));


        return checkBox;
    }

}
