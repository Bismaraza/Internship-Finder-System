package model;

public class Application {
    private int id;
    private int jobId;
    private int studentId;
    private int resumeId;
    private String status;
    private String coverNote;
    private String appliedAt;

    public Application() {}

    public Application(int id, int jobId, int studentId, int resumeId, String status, String coverNote, String appliedAt) {
        this.id = id;
        this.jobId = jobId;
        this.studentId = studentId;
        this.resumeId = resumeId;
        this.status = status;
        this.coverNote = coverNote;
        this.appliedAt = appliedAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getResumeId() { return resumeId; }
    public void setResumeId(int resumeId) { this.resumeId = resumeId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCoverNote() { return coverNote; }
    public void setCoverNote(String coverNote) { this.coverNote = coverNote; }

    public String getAppliedAt() { return appliedAt; }
    public void setAppliedAt(String appliedAt) { this.appliedAt = appliedAt; }

}
