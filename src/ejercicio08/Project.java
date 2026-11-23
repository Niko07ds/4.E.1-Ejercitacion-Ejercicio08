package ejercicio08;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de negocio que crea tareas. Recibe los oyentes desde afuera (inversión de control),
 * por lo que no conoce los módulos concretos que reciben las actualizaciones.
 */
public class Project {

    private final String name;
    private final List<TaskListener> defaultListeners;
    private final List<Task> tasks = new ArrayList<>();

    public Project(String name, List<TaskListener> defaultListeners) {
        this.name = name;
        this.defaultListeners = List.copyOf(defaultListeners);
    }

    public Task createTask(String title) {
        Task task = new Task(title);
        for (TaskListener listener : defaultListeners) {
            task.addListener(listener);
        }
        tasks.add(task);
        System.out.println("Proyecto " + name + ": se creó la tarea \"" + title + "\"");
        return task;
    }

    public String getName() {
        return name;
    }
}
