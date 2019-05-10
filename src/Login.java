import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;

public class Login extends JFrame implements ActionListener {

    JLabel usernameLabel;
    JTextField username;
    JLabel passwordLabel;
    JTextField password;
    JButton loginButton;
    JButton signupButton;

    JLabel status;

    public Login() {
        this.loginForm();
    }

    public void loginForm() {
        JFrame frame = new JFrame("JFrame Example");

        JPanel panel = new JPanel();

        panel.setLayout(null);


        //username
        usernameLabel = new JLabel("Username : ");
        usernameLabel.setBounds(20, 50, 100, 20);

        username = new JTextField();
        username.setBounds(120, 50, 150, 20);

        //password
        passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(20, 100, 100, 20);

        password = new JPasswordField();
        password.setBounds(120, 100, 150, 20);




        loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setBounds(200, 150, 80, 30);
        loginButton.addActionListener(this);


        signupButton = new JButton();
        signupButton.setText("Sign up");
        signupButton.setBounds(100, 150, 90, 30);
        signupButton.addActionListener(this);


        //status
        status = new JLabel("");
        status.setBounds(60, 200, 300, 20);

        panel.add(usernameLabel);
        panel.add(username);


        panel.add(passwordLabel);
        panel.add(password);

        panel.add(loginButton);
        panel.add(signupButton);

        panel.add(status);


        frame.add(panel);
        frame.setSize(300, 300);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.username.getText();
        String password = this.password.getText();


        MysqlCon mysqlCon = null;

        JButton button = (JButton) e.getSource();

        if(button.getText().equals("Login")) {


            try {
                mysqlCon = new MysqlCon();
                HashMap<String, String> user = mysqlCon.canLoginWith(username, password);

                System.out.println(username + " & "+ password + " : " + user.get("status"));

                if (user.get("status").equals("success")) {


                    status.setForeground(new Color(38, 139, 69));
                    status.setText("با موفقیت وارد شدید " + user.get("name") + " گرامی");
                } else {
                    status.setForeground(new Color(255, 44, 72));
                    status.setText("نام کاربری یا گذرواژه نادرست است");
                }


            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                mysqlCon = new MysqlCon();
                mysqlCon.signUpWith(username, password);
                loginButton.doClick();

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
