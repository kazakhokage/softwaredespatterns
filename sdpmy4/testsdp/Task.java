import java.util.ArrayList;
import java.util.List;

public class Task {
    private String description;
    private TaskDecorator decorator;
    private List<TaskObserver> observers = new ArrayList<>(); // observers

    public Task(String description) {
        this.description = description;
    }

    public void decorateWithPriority(TaskDecorator decorator) {
        if (decorator != null) {
            this.decorator = decorator;
        } else {
            System.out.println("Invalid decorator.");
        }
        notifyObservers(); // Notify observers
    }


    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update(this);
        }
    }

    public String getDescription() {
        if (decorator != null) {
            return decorator.decorate(description);
        }
        return description;
    }
}
