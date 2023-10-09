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
            System.out.println("3. Set Priority for Task");
            System.out.println("4. Exit");
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
                        for (int i = 0; i < tasks.size(); i++) {
                            Task task = tasks.get(i);
                            System.out.println(i + 1 + ". " + task.getDescription() + " (Priority: " + task.getPriority() + ")");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the task number to set priority: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    if (taskNumber >= 1 && taskNumber <= taskManager.getTasks().size()) {
                        System.out.print("Enter the new priority: ");
                        String newPriority = scanner.nextLine();
                        Task selectedTask = taskManager.getTasks().get(taskNumber - 1);
                        selectedTask.setPriority(newPriority);
                        System.out.println("Task priority set.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
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
