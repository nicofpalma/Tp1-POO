package ar.edu.unlu.poo.punto5;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Tarea> listaDeTareas = new ArrayList<>();

        // Lo divido en varias líneas para optimizar la visualización del código
        listaDeTareas.add(
                new Tarea(
                        "Ir al supermercado mañana",
                        "MEDIA",
                        false,
                        LocalDate.now().plusDays(1)
                )
        );
        listaDeTareas.add(
                new Tarea(
                        "Consultar repuesto del auto",
                        "MEDIA",
                        true,
                        LocalDate.now().minusDays(1)
                )
        );
        listaDeTareas.add(
                new Tarea(
                        "Ir al cine a ver la nueva película de Marvel",
                        "BAJA",
                        false,
                        LocalDate.now().minusDays(1)
                )
        );
        listaDeTareas.add(
                new Tarea(
                        "Estudiar matemática",
                        "MEDIA",
                        false,
                        LocalDate.now().plusDays(1)
                )
        );
        listaDeTareas.add(
                new Tarea(
                        "Comprar entradas para el teatro",
                        "BAJA",
                        false,
                        LocalDate.now().plusDays(3),
                        LocalDate.now().plusDays(1)
                )
        );
        listaDeTareas.add(
                new Tarea(
                        "Ir a una reunión laboral",
                        "ALTA",
                        false,
                        LocalDate.now().plusDays(2),
                        LocalDate.now()
                )
        );
        System.out.println("LISTA DE TAREAS:\n" + listaDeTareas + "\n-------------FIN DE LISTA DE TAREAS------------------");
        AdministradorDeTareas administradorDeTareas = new AdministradorDeTareas(listaDeTareas);
        administradorDeTareas.ordenarTareasPorPrioridad();
        System.out.println("\n----- TAREAS ORDENADAS POR PRIORIDAD ------ \n" + administradorDeTareas + "\n-------------FIN DE ADMINISTRADOR DE TAREAS------------------");
        administradorDeTareas.ordenarTareasPorFechaDeVencimiento();
        System.out.println("\n----- TAREAS ORDENADAS POR FECHA DE VENCIMIENTO ------ \n" + administradorDeTareas + "\n-------------FIN DE ADMINISTRADOR DE TAREAS------------------");

        Tarea tareaBuscadaPorTitulo = administradorDeTareas.buscarPorTitulo("Estudiar matemática");
        System.out.println("\nBUSQUEDA POR TITULO:\n" + administradorDeTareas.buscarPorTitulo("Consultar repuesto del auto"));
        System.out.println("\nBUSQUEDA POR TITULO:\n" + tareaBuscadaPorTitulo);

        administradorDeTareas.agregarColaborador("Carlos");
        administradorDeTareas.agregarColaborador("Juan");
        administradorDeTareas.agregarColaborador("José");
        administradorDeTareas.agregarColaborador("Nicolás");
        administradorDeTareas.agregarColaborador("Pedro");

        if(tareaBuscadaPorTitulo.estaCompleta()){
            System.out.println("La tarea " + tareaBuscadaPorTitulo.getDescripcion() + " ya está completa.");
        } else {
            administradorDeTareas.marcarCompleta(tareaBuscadaPorTitulo, "Nicolás");
            System.out.println("La tarea " + tareaBuscadaPorTitulo.getDescripcion() + " ahora está completa.");
        }

        Tarea tareaBuscadaPorTitulo2 = administradorDeTareas.buscarPorTitulo("Ir a una reunión laboral");
        if(tareaBuscadaPorTitulo2.estaCompleta()){
            System.out.println("La tarea " + tareaBuscadaPorTitulo2.getDescripcion() + " ya está completa");
        } else {
            administradorDeTareas.marcarCompleta(tareaBuscadaPorTitulo2, "Nicolás");
            System.out.println("La tarea " + tareaBuscadaPorTitulo2.getDescripcion() + " ahora está completa.");
        }

        System.out.println("\n---- OBTENER TAREAS POR COLABORADOR (NICOLÁS) ----\n" + administradorDeTareas.buscarTareasPorColaborador("Nicolás") + "\n--------------FIN DE LAS TAREAS POR COLABORADOR----------------");
        System.out.println("\n------ ESTADO FINAL DEL ADMINISTRADOR DE TAREAS ------\n" + administradorDeTareas);
    }


}
