package model;

public class Bookmark {
    private int id;
    private int studentId;
    private int jobId;
    private String createdAt;

    public Bookmark() {}

    public Bookmark(int id, int studentId, int jobId, String createdAt) {
        this.id = id;
        this.studentId = studentId;
        this.jobId = jobId;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

}
