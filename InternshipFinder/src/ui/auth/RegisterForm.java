package ui.auth;
import javax.swing.*;
import java.awt.*;
import controller.AuthController;
import util.*;

public class RegisterForm extends JFrame {
    JTextField name=UITheme.textField(), email=UITheme.textField(); JPasswordField password=UITheme.passwordField(); JComboBox<String> role=new JComboBox<>(new String[]{Constants.ROLE_STUDENT,Constants.ROLE_EMPLOYER});
    public RegisterForm(){ setTitle("Register"); setSize(500,520); UITheme.applyFrame(this); JPanel p=UITheme.panel(); p.setLayout(new GridLayout(0,1,0,9)); p.add(UITheme.title("Create Account")); p.add(UITheme.label("Full Name")); p.add(name); p.add(UITheme.label("Email")); p.add(email); p.add(UITheme.label("Password")); p.add(password); p.add(UITheme.label("Role")); p.add(role); JButton b=UITheme.button("Register"); JButton back=UITheme.button("Back to Login"); p.add(b); p.add(back); add(p); b.addActionListener(e->register()); back.addActionListener(e->{dispose(); new LoginForm();}); setVisible(true); }
    private void register(){ String res=new AuthController().register(name.getText(),email.getText(),new String(password.getPassword()),role.getSelectedItem().toString()); if("SUCCESS".equals(res)){ DialogUtil.success(this,"Account created successfully."); dispose(); new LoginForm(); } else DialogUtil.error(this,res); }
}
