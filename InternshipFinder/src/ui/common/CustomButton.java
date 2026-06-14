package ui.common;
import javax.swing.*;
import util.UITheme;
public class CustomButton extends JButton { public CustomButton(String text){ super(text); setFocusPainted(false); setBackground(UITheme.ACCENT); setForeground(java.awt.Color.WHITE); setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13)); } }
