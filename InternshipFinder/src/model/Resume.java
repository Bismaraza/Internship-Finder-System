package model;

public class Resume {
    private int id;
    private int studentId;
    private String title;
    private String resumePath;
    private String coverLetterPath;
    private String studentIdPath;
    private String createdAt;

    public Resume() {}

    public Resume(int id, int studentId, String title, String resumePath, String coverLetterPath, String studentIdPath, String createdAt) {
        this.id = id;
        this.studentId = studentId;
        this.title = title;
        this.resumePath = resumePath;
        this.coverLetterPath = coverLetterPath;
        this.studentIdPath = studentIdPath;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getResumePath() { return resumePath; }
    public void setResumePath(String resumePath) { this.resumePath = resumePath; }

    public String getCoverLetterPath() { return coverLetterPath; }
    public void setCoverLetterPath(String coverLetterPath) { this.coverLetterPath = coverLetterPath; }

    public String getStudentIdPath() { return studentIdPath; }
    public void setStudentIdPath(String studentIdPath) { this.studentIdPath = studentIdPath; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

}
