package ui.common;
import javax.swing.*;
import util.UITheme;
public class CustomPasswordField extends JPasswordField { public CustomPasswordField(){ super(); setBackground(UITheme.PANEL_2); setForeground(UITheme.TEXT); setCaretColor(UITheme.TEXT); setBorder(javax.swing.BorderFactory.createEmptyBorder(8,10,8,10)); } }
