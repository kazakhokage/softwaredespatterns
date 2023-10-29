public class PriorityTaskDecorator implements TaskDecorator {
    private String priority;

    public PriorityTaskDecorator(String priority) {
        this.priority = priority;
    }

    @Override
    public String decorate(String description) {
        return "Priority: " + priority + ", " + description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
