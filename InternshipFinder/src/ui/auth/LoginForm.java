package ui.auth;

import javax.swing.*;
import java.awt.*;

import controller.AuthController;
import model.User;
import util.UITheme;
import util.DialogUtil;
import util.Constants;
import ui.student.StudentDashboard;
import ui.employer.EmployerDashboard;
import ui.admin.AdminDashboard;

public class LoginForm extends JFrame {

    private JTextField email = UITheme.textField();
    private JPasswordField password = UITheme.passwordField();

    public LoginForm() {
        setTitle("Login - Internship Finder");
        setSize(460, 430);
        UITheme.applyFrame(this);

        JPanel p = UITheme.panel();
        p.setLayout(new GridLayout(0, 1, 0, 10));

        p.add(UITheme.title("Login"));
        p.add(UITheme.label("Email"));
        p.add(email);
        p.add(UITheme.label("Password"));
        p.add(password);

        JButton login = UITheme.button("Login");
        JButton reg = UITheme.button("Create New Account");

        p.add(login);
        p.add(reg);
        add(p);

        login.addActionListener(e -> doLogin());

        reg.addActionListener(e -> {
            dispose();
            new RegisterForm();
        });

        setVisible(true);
    }

    private void doLogin() {
        User u = new AuthController().login(
                email.getText(),
                new String(password.getPassword())
        );

        if (u == null) {
            DialogUtil.error(this, "Invalid login details or inactive account.");
            return;
        }

        dispose();

        if (Constants.ROLE_STUDENT.equals(u.getRole())) {
            new StudentDashboard();
        } else if (Constants.ROLE_EMPLOYER.equals(u.getRole())) {
            new EmployerDashboard();
        } else {
            new AdminDashboard();
        }
    }
}