package view;

import com.sun.prism.shader.FillCircle_LinearGradient_REFLECT_AlphaTest_Loader;
import components.termsAdapter;
import dataModels.Term;
import listeners.absentButtonListener;
import listeners.projectButtonListener;
import model.termsModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TermsList {

    private JList list;
    private JPanel panel;
    private JTextArea status;
    private ArrayList<Term> Terms;
    private String termSelect;

    private JButton projects_btn;
    private JButton absents_btn;

    private projectButtonListener projectsBtnListener;
    private absentButtonListener absentBtnListener;


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
                try {
                    jList1ValueChanged(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        list.setPreferredSize(new Dimension(200, 800));
        list.setBorder(new EmptyBorder(50, 0, 100, 0));
        list.setFixedCellHeight(40);
        list.setFixedCellWidth(100);
        list.setSelectionBackground(new Color(38, 139, 69));
        list.setSelectionForeground(Color.white);


        projects_btn = new JButton("projects");
        absents_btn = new JButton("absents");


        projectsBtnListener = new projectButtonListener();
        absentBtnListener = new absentButtonListener();

        projects_btn.addActionListener(projectsBtnListener);
        absents_btn.addActionListener(absentBtnListener);

        panel.add(projects_btn);
        panel.add(absents_btn);
        panel.add(list);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) throws SQLException {
        //set text on left here
        this.termSelect = (String) list.getSelectedValue();

        termsAdapter.setCurrentTerm(termsModel.getId(this.termSelect));

        projectsBtnListener.setTerm(this.termSelect);
        absentBtnListener.setTerm(this.termSelect);

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
