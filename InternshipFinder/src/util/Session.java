package util;

import model.User;

public class Session {
    private static User currentUser;
    public static void setCurrentUser(User user) { currentUser = user; }
    public static User getCurrentUser() { return currentUser; }
    public static int getUserId() { return currentUser == null ? 0 : currentUser.getId(); }
    public static String getRole() { return currentUser == null ? "" : currentUser.getRole(); }
    public static void clear() { currentUser = null; }
}
