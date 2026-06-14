package model;

public class Admin {
    private int id;
    private int userId;
    private String level;

    public Admin() {}

    public Admin(int id, int userId, String level) {
        this.id = id;
        this.userId = userId;
        this.level = level;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

}
