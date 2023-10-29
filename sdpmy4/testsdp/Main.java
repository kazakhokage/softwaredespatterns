import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = TaskManager.getInstance();

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Add Priority");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(description);
                    taskManager.addTask(task);
                    System.out.println("Task added.");
                    TaskObserver loggerObserver = new TaskLoggingObserver();
                    task.addObserver(loggerObserver);
                }
                case 2 -> {
                    List<Task> tasks = taskManager.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("Tasks:");
                        for (Task t : tasks) {
                            System.out.println(t.getDescription());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter task number to decorate with priority: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (taskNumber >= 1 && taskNumber <= taskManager.getTasks().size()) {
                        System.out.print("Enter priority: ");
                        String priority = scanner.nextLine();
                        Task selectedTask = taskManager.getTasks().get(taskNumber - 1);

                        TaskDecorator priorityDecorator = new PriorityTaskDecoratorAdapter(priority);
                            selectedTask.decorateWithPriority(priorityDecorator);
                        System.out.println("Priority added.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting Task Manager.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
