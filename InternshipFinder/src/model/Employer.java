package model;

public class Employer {
    private int id;
    private int userId;
    private String designation;
    private String phone;

    public Employer() {}

    public Employer(int id, int userId, String designation, String phone) {
        this.id = id;
        this.userId = userId;
        this.designation = designation;
        this.phone = phone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

}
