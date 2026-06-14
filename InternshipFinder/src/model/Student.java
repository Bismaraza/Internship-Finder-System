package model;

public class Student {
    private int id;
    private int userId;
    private String fullName;
    private String education;
    private String skills;
    private String fieldOfStudy;
    private String city;
    private String availability;
    private String phone;

    public Student() {}

    public Student(int id, int userId, String fullName, String education, String skills, String fieldOfStudy, String city, String availability, String phone) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.education = education;
        this.skills = skills;
        this.fieldOfStudy = fieldOfStudy;
        this.city = city;
        this.availability = availability;
        this.phone = phone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getFieldOfStudy() { return fieldOfStudy; }
    public void setFieldOfStudy(String fieldOfStudy) { this.fieldOfStudy = fieldOfStudy; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

}
