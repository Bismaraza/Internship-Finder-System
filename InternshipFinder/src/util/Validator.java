package util;

public class Validator {
    public static boolean isEmpty(String s) { return s == null || s.trim().isEmpty(); }
    public static boolean isValidEmail(String email) { return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"); }
    public static boolean isStrongPassword(String password) { return password != null && password.length() >= 6; }
    public static boolean isValidDocument(String name) {
        if (name == null) return false;
        String n = name.toLowerCase();
        return n.endsWith(".pdf") || n.endsWith(".doc") || n.endsWith(".docx");
    }
}
