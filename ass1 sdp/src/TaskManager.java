import java.util.ArrayList;
import java.util.List;
//class to add tasks and get the list of tasks using singleton pattern
public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;

    private TaskManager() {
        tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
