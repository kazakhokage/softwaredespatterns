public class Task {
    private String description;
    private TaskDecorator decorator;

    public Task(String description) {
        this.description = description;
    }

    public void decorateWithPriority(TaskDecorator decorator) {
        if (decorator != null) {
            this.decorator = decorator;
        } else {
            System.out.println("Invalid decorator.");
        }
    }

    public String getDescription() {
        if (decorator != null) {
            return decorator.decorate(description);
        }
        return description;
    }
}
