import java.util.List;
import java.util.Scanner;
//cli for task manager
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = TaskManager.getInstance();

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    System.out.println("Task added.");
                    break;
                case 2:
                    List<Task> tasks = taskManager.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("Tasks:");
                        for (Task task : tasks) {
                            System.out.println(task.    getDescription());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting Task Manager.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
