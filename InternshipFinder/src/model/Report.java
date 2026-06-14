package model;

public class Report {
    private int id;
    private int userId;
    private int jobId;
    private String reason;
    private String status;
    private String createdAt;

    public Report() {}

    public Report(int id, int userId, int jobId, String reason, String status, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.jobId = jobId;
        this.reason = reason;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

}
