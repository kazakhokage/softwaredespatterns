class TaskManager {
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

    public void addTask(String description, String priority) {
        Task task = new Task(description, priority);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void updateTaskPriority(int taskIndex, String newPriority) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setPriority(newPriority);
        }
    }
}
