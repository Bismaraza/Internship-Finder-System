package ui.common;
import javax.swing.*;
import java.awt.*;
import util.UITheme;
public class DashboardCard extends JPanel { public DashboardCard(String title,String value){ setLayout(new BorderLayout()); setBackground(UITheme.PANEL_2); setBorder(BorderFactory.createEmptyBorder(15,15,15,15)); JLabel v=new JLabel(value); v.setForeground(UITheme.ACCENT); v.setFont(new Font("Segoe UI",Font.BOLD,26)); JLabel t=new JLabel(title); t.setForeground(UITheme.MUTED); add(v,BorderLayout.CENTER); add(t,BorderLayout.SOUTH); } }
