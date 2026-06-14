package util;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UITheme {

    // Main Theme Colors: Black, White, Yellow
    public static final Color BG = new Color(8, 8, 8);                 // Main black background
    public static final Color PANEL = new Color(18, 18, 18);           // Dark panel/card
    public static final Color PANEL_2 = new Color(28, 28, 28);         // Input/table dark color

    public static final Color ACCENT = new Color(255, 193, 7);         // Professional yellow
    public static final Color ACCENT_2 = new Color(255, 215, 0);       // Bright yellow/gold

    public static final Color TEXT = Color.WHITE;                      // Main white text
    public static final Color MUTED = new Color(210, 210, 210);        // Soft white/grey text

    public static final Color DANGER = new Color(220, 53, 69);         // Error red
    public static final Color SUCCESS = new Color(40, 167, 69);        // Success green

    public static final Color BORDER = new Color(255, 193, 7);         // Yellow border
    public static final Color TABLE_HEADER = new Color(255, 193, 7);   // Yellow table header
    public static final Color TABLE_ROW = new Color(15, 15, 15);       // Black row
    public static final Color TABLE_ROW_ALT = new Color(25, 25, 25);   // Alternate row

    // Fonts
    public static final Font TITLE = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font SUBTITLE = new Font("Segoe UI", Font.BOLD, 16);
    public static final Font BODY = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 13);

    public static void applyFrame(JFrame frame) {
        frame.getContentPane().setBackground(BG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public static JPanel panel() {
        JPanel p = new JPanel();
        p.setBackground(PANEL);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));
        return p;
    }

    public static JLabel title(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(TEXT);
        l.setFont(TITLE);
        return l;
    }

    public static JLabel subtitle(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(ACCENT);
        l.setFont(SUBTITLE);
        return l;
    }

    public static JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(MUTED);
        l.setFont(BODY);
        return l;
    }

    public static JButton button(String text) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setBackground(ACCENT);
        b.setForeground(Color.BLACK);
        b.setFont(BUTTON_FONT);
        b.setBorder(new EmptyBorder(10, 16, 10, 16));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static JButton darkButton(String text) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setBackground(PANEL_2);
        b.setForeground(TEXT);
        b.setFont(BUTTON_FONT);
        b.setBorder(new EmptyBorder(10, 16, 10, 16));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static JButton dangerButton(String text) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setBackground(DANGER);
        b.setForeground(Color.WHITE);
        b.setFont(BUTTON_FONT);
        b.setBorder(new EmptyBorder(10, 16, 10, 16));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    public static JTextField textField() {
        JTextField t = new JTextField();
        t.setBackground(PANEL_2);
        t.setForeground(TEXT);
        t.setCaretColor(ACCENT);
        t.setFont(BODY);
        t.setBorder(new EmptyBorder(9, 10, 9, 10));
        return t;
    }

    public static JPasswordField passwordField() {
        JPasswordField t = new JPasswordField();
        t.setBackground(PANEL_2);
        t.setForeground(TEXT);
        t.setCaretColor(ACCENT);
        t.setFont(BODY);
        t.setBorder(new EmptyBorder(9, 10, 9, 10));
        return t;
    }

    public static JTextArea textArea() {
        JTextArea t = new JTextArea();
        t.setBackground(PANEL_2);
        t.setForeground(TEXT);
        t.setCaretColor(ACCENT);
        t.setFont(BODY);
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        t.setBorder(new EmptyBorder(9, 10, 9, 10));
        return t;
    }

    public static JComboBox<String> comboBox(String[] items) {
        JComboBox<String> c = new JComboBox<>(items);
        c.setBackground(PANEL_2);
        c.setForeground(TEXT);
        c.setFont(BODY);
        c.setFocusable(false);
        return c;
    }

    public static void styleTable(JTable table) {
        table.setBackground(TABLE_ROW);
        table.setForeground(TEXT);
        table.setFont(BODY);
        table.setRowHeight(28);
        table.setGridColor(new Color(50, 50, 50));
        table.setSelectionBackground(ACCENT);
        table.setSelectionForeground(Color.BLACK);

        table.getTableHeader().setBackground(TABLE_HEADER);
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    public static JScrollPane scrollPane(Component component) {
        JScrollPane sp = new JScrollPane(component);
        sp.getViewport().setBackground(PANEL);
        sp.setBorder(BorderFactory.createLineBorder(BORDER, 1));
        return sp;
    }
}