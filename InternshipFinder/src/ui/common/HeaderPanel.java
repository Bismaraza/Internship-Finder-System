package ui.common;
import javax.swing.*;
import java.awt.*;
import util.*;
public class HeaderPanel extends JPanel { public HeaderPanel(String title){ setLayout(new BorderLayout()); setBackground(UITheme.PANEL); setBorder(BorderFactory.createEmptyBorder(12,18,12,18)); JLabel l=UITheme.title(title); JLabel user=UITheme.label(Session.getCurrentUser()==null?"Guest":Session.getCurrentUser().getName()+" | "+Session.getRole()); add(l,BorderLayout.WEST); add(user,BorderLayout.EAST); } }
