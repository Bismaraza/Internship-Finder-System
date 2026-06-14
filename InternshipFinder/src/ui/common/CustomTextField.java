package ui.common;
import javax.swing.*;
import util.UITheme;
public class CustomTextField extends JTextField { public CustomTextField(){ super(); setBackground(UITheme.PANEL_2); setForeground(UITheme.TEXT); setCaretColor(UITheme.TEXT); setBorder(javax.swing.BorderFactory.createEmptyBorder(8,10,8,10)); } }
