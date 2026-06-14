package ui.auth;
import javax.swing.*;
import java.awt.*;
import util.UITheme;
public class SplashScreen extends JFrame { public SplashScreen(){ setTitle("Internship Finder"); setSize(520,300); UITheme.applyFrame(this); JPanel p=UITheme.panel(); p.setLayout(new GridBagLayout()); JLabel title=UITheme.title("Internship Finder System"); JLabel sub=UITheme.label("Java Swing + MySQL Professional Semester Project"); JPanel box=new JPanel(new GridLayout(2,1,0,10)); box.setBackground(UITheme.PANEL); box.add(title); box.add(sub); p.add(box); add(p); setVisible(true); Timer timer=new Timer(1200,e->{ dispose(); new LoginForm(); }); timer.setRepeats(false); timer.start(); } }
