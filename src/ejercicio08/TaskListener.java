package ejercicio08;

/**
 * Abstracción que reemplaza las dependencias directas de la tarea.
 * Cualquier módulo interesado en los cambios de estado la implementa.
 */
public interface TaskListener {

    void onTaskStatusChanged(TaskEvent event);
}
