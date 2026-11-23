package ejercicio08;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Único lugar donde se conocen los módulos concretos: la composición del programa
        EmailNotifier emailNotifier = new EmailNotifier();
        StatisticsModule statisticsModule = new StatisticsModule();

        Project project = new Project("Rediseño del portal", List.of(emailNotifier, statisticsModule));

        System.out.println("Creando tareas del proyecto");
        Task design = project.createTask("Diseñar la pantalla de inicio");
        Task testing = project.createTask("Probar el formulario de contacto");

        System.out.println();
        System.out.println("La primera tarea comienza");
        design.changeStatus(TaskStatus.IN_PROGRESS);

        System.out.println();
        System.out.println("La primera tarea se finaliza");
        design.changeStatus(TaskStatus.DONE);

        System.out.println();
        System.out.println("Se repite el mismo estado (no hay notificaciones)");
        design.changeStatus(TaskStatus.DONE);

        System.out.println();
        System.out.println("Se desvincula el módulo de correo de la segunda tarea");
        testing.removeListener(emailNotifier);
        testing.changeStatus(TaskStatus.DONE);

        System.out.println();
        statisticsModule.printSummary();
    }
}
