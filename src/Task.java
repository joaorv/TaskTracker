import java.util.Date;

public class Task {
    private static int nextId = 1;
    private int id;
    private String description;

    public enum Status{
        TODO,
        DONE,
        IN_PROGRESS
    }

    private Status status;
    private Date createdAt;
    private Date updatedAt;

    public Task(String description) {
        this.id = nextId++;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public Status getStatus() { return status; }
    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }

    public void setStatus(Status status) {
        this.status = status;
        this.updatedAt = new Date();
    }
}
