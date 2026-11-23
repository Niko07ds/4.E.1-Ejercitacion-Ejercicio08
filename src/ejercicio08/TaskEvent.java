package ejercicio08;

/**
 * Evento inmutable que describe un cambio de estado de una tarea.
 */
public record TaskEvent(String taskTitle, TaskStatus oldStatus, TaskStatus newStatus) {
}
