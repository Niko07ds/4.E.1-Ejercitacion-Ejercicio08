package ejercicio08;

/**
 * Módulo de estadísticas. Acumula datos a partir de los eventos recibidos.
 */
public class StatisticsModule implements TaskListener {

    private int totalChanges;
    private int completedTasks;

    @Override
    public void onTaskStatusChanged(TaskEvent event) {
        totalChanges++;
        if (event.newStatus() == TaskStatus.DONE) {
            completedTasks++;
        }
        System.out.println("Estadísticas: cambio registrado (total " + totalChanges + ")");
    }

    public void printSummary() {
        System.out.println("Resumen de estadísticas: " + totalChanges + " cambio(s) de estado, "
                + completedTasks + " tarea(s) finalizada(s)");
    }
}
