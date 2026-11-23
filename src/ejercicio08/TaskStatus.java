package ejercicio08;

/**
 * Estados posibles de una tarea.
 */
public enum TaskStatus {
    TODO("Pendiente"),
    IN_PROGRESS("En progreso"),
    DONE("Finalizada");

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
