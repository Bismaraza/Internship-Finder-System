package ui.common;
import javax.swing.*;
import util.UITheme;
public class TableStyle { public static void apply(JTable t){ t.setBackground(UITheme.PANEL_2); t.setForeground(UITheme.TEXT); t.setGridColor(UITheme.BG); t.setRowHeight(28); t.getTableHeader().setBackground(UITheme.BG); t.getTableHeader().setForeground(UITheme.TEXT); } }
