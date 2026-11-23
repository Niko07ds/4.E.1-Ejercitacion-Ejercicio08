package ejercicio08;

import java.util.ArrayList;
import java.util.List;

/**
 * Tarea (sujeto observable).
 * Solo gestiona su propio estado y notifica a su lista abstracta de oyentes.
 * No conoce ningún módulo concreto (correo, estadísticas, etc.).
 */
public class Task {

    private final String title;
    private TaskStatus status = TaskStatus.TODO;
    private final List<TaskListener> listeners = new ArrayList<>();

    public Task(String title) {
        this.title = title;
    }

    public void addListener(TaskListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeListener(TaskListener listener) {
        listeners.remove(listener);
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == status) {
            return;
        }
        TaskStatus oldStatus = status;
        status = newStatus;
        TaskEvent event = new TaskEvent(title, oldStatus, newStatus);
        for (TaskListener listener : new ArrayList<>(listeners)) {
            listener.onTaskStatusChanged(event);
        }
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
