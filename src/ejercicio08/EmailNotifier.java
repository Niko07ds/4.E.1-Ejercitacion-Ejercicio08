package ejercicio08;

/**
 * Módulo de notificaciones por correo. Es un oyente independiente de la tarea.
 */
public class EmailNotifier implements TaskListener {

    @Override
    public void onTaskStatusChanged(TaskEvent event) {
        System.out.println("Correo: aviso enviado, la tarea \"" + event.taskTitle() + "\" pasó de "
                + event.oldStatus().getLabel() + " a " + event.newStatus().getLabel());
    }
}
