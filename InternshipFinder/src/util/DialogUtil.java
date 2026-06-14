package util;

import javax.swing.*;

public class DialogUtil {
    public static void success(java.awt.Component parent, String msg) { JOptionPane.showMessageDialog(parent, msg, "Success", JOptionPane.INFORMATION_MESSAGE); }
    public static void error(java.awt.Component parent, String msg) { JOptionPane.showMessageDialog(parent, msg, "Error", JOptionPane.ERROR_MESSAGE); }
    public static boolean confirm(java.awt.Component parent, String msg) { return JOptionPane.showConfirmDialog(parent, msg, "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION; }
}
