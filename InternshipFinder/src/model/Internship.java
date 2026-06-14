package model;

public class Internship {
    private int id;
    private int companyId;
    private String title;
    private String field;
    private String city;
    private String type;
    private String duration;
    private double stipend;
    private String requirements;
    private String description;
    private String deadline;
    private String status;
    private String createdAt;

    public Internship() {}

    public Internship(int id, int companyId, String title, String field, String city, String type, String duration, double stipend, String requirements, String description, String deadline, String status, String createdAt) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.field = field;
        this.city = city;
        this.type = type;
        this.duration = duration;
        this.stipend = stipend;
        this.requirements = requirements;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getStipend() { return stipend; }
    public void setStipend(double stipend) { this.stipend = stipend; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

}
