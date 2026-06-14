package ui.common;
import javax.swing.*;
import java.awt.*;
import util.UITheme;
public class SidebarPanel extends JPanel {
    public SidebarPanel(String[] items, java.awt.event.ActionListener listener){
        setLayout(new GridLayout(items.length+1,1,0,8)); setBackground(UITheme.BG); setBorder(BorderFactory.createEmptyBorder(15,10,15,10));
        JLabel logo=new JLabel("INTERNSHIP PORTAL",SwingConstants.CENTER); logo.setForeground(UITheme.ACCENT); logo.setFont(new Font("Segoe UI",Font.BOLD,18)); add(logo);
        for(String item:items){ JButton b=new JButton(item); b.setActionCommand(item); b.addActionListener(listener); b.setFocusPainted(false); b.setBackground(UITheme.PANEL); b.setForeground(UITheme.TEXT); add(b); }
    }
}
