public class TaskLoggingObserver implements TaskObserver {
    @Override
    public void update(Task task) {
        System.out.println("Task updated: " + task.getDescription());
    }
}
