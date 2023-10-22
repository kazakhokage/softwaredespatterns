public class PriorityTaskDecoratorAdapter implements TaskDecorator {
    private PriorityTaskDecorator priorityTaskDecorator;

    public PriorityTaskDecoratorAdapter(String priority) {
        this.priorityTaskDecorator = new PriorityTaskDecorator(priority);
    }

    @Override
    public String decorate(String description) {
        return priorityTaskDecorator.decorate(description);
    }
}
