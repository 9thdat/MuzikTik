package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controller.LoginPageListener;
import DAO.UserDAO;
import Model.User;
import com.intellij.uiDesigner.core.*;
import com.mysql.cj.log.Log;

public class LoginPage extends JPanel {
    ActionListener ac = new LoginPageListener(this);
    User user = new User();
    public LoginPage() {
        initComponents();
    }

    private void Login(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        LoginPage = new JDialog();
        label1 = new JLabel();
        UsernameField = new JTextField();
        PasswordField = new JPasswordField();
        label2 = new JLabel();
        Password = new JLabel();
        LoginButton = new JButton();
        LoginStatus = new JLabel();

        //======== LoginPage ========
        {
            LoginPage.setTitle("Concert Go");
            LoginPage.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            LoginPage.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            LoginPage.setName("LoginPage");
            LoginPage.setVisible(true);
            LoginPage.setBackground(Color.white);
            LoginPage.setForeground(SystemColor.controlDkShadow);
            var LoginPageContentPane = LoginPage.getContentPane();
            LoginPageContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("LOGIN");
            label1.setIcon(new ImageIcon(getClass().getResource("/Asset/icons8-login-64.png")));
            label1.setFont(new Font("UTM Avo", Font.BOLD, 26));
            LoginPageContentPane.add(label1);
            label1.setBounds(275, 60, 175, 70);
            LoginPageContentPane.add(UsernameField);
            UsernameField.setBounds(250, 180, 270, 45);
            LoginPageContentPane.add(PasswordField);
            PasswordField.setBounds(250, 255, 270, 45);

            //---- label2 ----
            label2.setText("Username:");
            label2.setFont(new Font("UTM Avo", Font.PLAIN, 12));
            LoginPageContentPane.add(label2);
            label2.setBounds(160, 185, 90, 35);

            //---- Password ----
            Password.setText("Password:");
            LoginPageContentPane.add(Password);
            Password.setBounds(160, 260, 80, 35);

            //---- LoginButton ----
            LoginButton.setText("LOGIN");
            LoginButton.setFont(new Font("SVN-Avo", Font.BOLD, 12));
            LoginButton.addActionListener(e -> {
			Login(e);
			Login(e);
		});
            LoginPageContentPane.add(LoginButton);
            LoginButton.setBounds(new Rectangle(new Point(325, 350), LoginButton.getPreferredSize()));
            LoginPageContentPane.add(LoginStatus);
            LoginStatus.setBounds(270, 385, 185, 25);

            LoginPageContentPane.setPreferredSize(new Dimension(705, 465));
            LoginPage.pack();
            LoginPage.setLocationRelativeTo(LoginPage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JDialog LoginPage;
    private JLabel label1;
    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JLabel label2;
    private JLabel Password;
    private JButton LoginButton;
    private JLabel LoginStatus;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public void DoLogin(){
        String username = this.UsernameField.getText();
        String password = this.PasswordField.getText();

        User realuser = UserDAO.getInstance().selectById(username);

        if (realuser == null) {
            this.LoginStatus.setText("Login Failed");
            this.LoginStatus.setForeground(Color.RED);
            return;
        }
        else {
            String realUsername = realuser.getUsername();
            String realPassword = realuser.getPassword();

            if (username.equals(realUsername) && password.equals(realPassword)) {
                this.LoginStatus.setText("Login Success");
                this.LoginStatus.setForeground(Color.GREEN);
            } else {
                this.LoginStatus.setText("Login Failed");
                this.LoginStatus.setForeground(Color.RED);
            }
        }
    }
}
