import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TaskManager {
    private List<Task> tasks = new ArrayList<Task>();

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void removeTaskById(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void listAllTasks() {
        System.out.printf("%-5s %-12s %-30s %-20s%n", "ID", "STATUS", "DESCRIPTION", "CREATED AT");
        System.out.println("---------------------------------------------------------------");
        for (Task task : tasks) {
            System.out.printf(
                    "%-5d %-12s %-30s %-20s%n",
                    task.getId(),
                    task.getStatus(),
                    task.getDescription(),
                    task.getCreatedAt()
            );
        }
    }


    public void listTasksByStatus(Task.Status status) {
        System.out.printf("%-5s %-12s %-30s %-20s%n", "ID", "STATUS", "DESCRIPTION", "CREATED AT");
        System.out.println("---------------------------------------------------------------");
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                System.out.printf(
                        "%-5d %-12s %-30s %-20s%n",
                        task.getId(),
                        task.getStatus(),
                        task.getDescription(),
                        task.getCreatedAt()
                );
            }
        }
    }

    public void upadateTaskStatus(int id, Task.Status newstatus) {
        for (Task task : tasks) {
            if(task.getId() == id) {
                task.setStatus(newstatus);
                break;
            }
        }
    }

    public void saveToFile(){
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter("src/data/tasks.json")) {
            gson.toJson(tasks, writer);
            System.out.println("Tarefas salvas");
        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        Gson gson = new Gson();
        Type taskListType = new TypeToken<List<Task>>(){}.getType();

        try (FileReader reader = new FileReader("src/data/tasks.json")) {
            tasks = gson.fromJson(reader, taskListType);
            int maxId = tasks.stream().mapToInt(Task::getId).max().orElse(0);
            Task.setNextId(maxId + 1);
            System.out.println("Tarefas carregadas");
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }
}
