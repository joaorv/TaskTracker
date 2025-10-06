import java.util.Date;

public class Task {
    int id;
    String description;
    public enum status{
        TODO,
        DONE,
        IN_PROGRESS
    }
    Date createdAt;
    Date updatedAt;
}
