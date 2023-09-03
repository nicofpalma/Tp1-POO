package ar.edu.unlu.poo.punto5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDeTareas {
    private List<Tarea> tareas;
    private List<String> colaboradores;

    public AdministradorDeTareas(List<Tarea> tareas){
        this.tareas = tareas;
        colaboradores = new ArrayList<>();
    }

    public void agregarColaborador(String colaborador){
        colaboradores.add(colaborador);
    }

    public String getColaboradores(){
        String colaboradores = "";
        for (int i = 0; i < this.colaboradores.size(); i++) {
            colaboradores += this.colaboradores.get(i);
        }
        return colaboradores;
    }

    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public String toString(){
        String mostrarTareas = "";
        for (int i = 0; i < tareas.size(); i++) {
            if(!tareas.get(i).estaVencida()){
                mostrarTareas += tareas.get(i);
            }
        }
        return mostrarTareas;
    }

    public void ordenarTareasPorPrioridad(){
        List<Tarea> tareasOrdenadas = new ArrayList<>(tareas);
        for (int i = 0; i < tareasOrdenadas.size() - 1; i++) {
            for (int j = 0; j < tareasOrdenadas.size() - i - 1; j++) {
                Tarea tareaActual = tareasOrdenadas.get(j);
                Tarea tareaSiguiente = tareasOrdenadas.get(j + 1);

                if(menorPrioridad(tareaActual, tareaSiguiente)){
                    Tarea tareaTemp = tareaActual;
                    tareasOrdenadas.set(j, tareaSiguiente);
                    tareasOrdenadas.set(j + 1, tareaTemp);
                }
            }
        }
        tareas = tareasOrdenadas;
    }

    public void ordenarTareasPorFechaDeVencimiento(){
        List<Tarea> tareasOrdenadas = new ArrayList<>(tareas);
        for (int i = 0; i < tareasOrdenadas.size() - 1; i++) {
            for (int j = 0; j < tareasOrdenadas.size() - i - 1; j++) {
                Tarea tareaActual = tareasOrdenadas.get(j);
                Tarea tareaSiguiente = tareasOrdenadas.get(j + 1);

                if(venceAntes(tareaActual, tareaSiguiente)){
                    Tarea tareaTemp = tareaActual;
                    tareasOrdenadas.set(j, tareaSiguiente);
                    tareasOrdenadas.set(j + 1, tareaTemp);
                }
            }
        }
        tareas = tareasOrdenadas;
    }

    public boolean venceAntes(Tarea tarea1, Tarea tarea2){
        LocalDate vencimiento1 = tarea1.getFechaLimite();
        LocalDate vencimiento2 = tarea2.getFechaLimite();

        return (vencimiento1.isAfter(vencimiento2));
    }

    public boolean menorPrioridad(Tarea tarea1, Tarea tarea2) {
        Tarea.Prioridad prioridad1 = tarea1.getPrioridad();
        Tarea.Prioridad prioridad2 = tarea2.getPrioridad();

        if (prioridad1 == prioridad2) {
            return false;
        } else if (prioridad1 == Tarea.Prioridad.BAJA) {
            return true;
        } else if (prioridad1 == Tarea.Prioridad.MEDIA && prioridad2 != Tarea.Prioridad.BAJA) {
            return true;
        }

        return false;
    }

    public Tarea buscarPorTitulo(String titulo){
        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).getDescripcion().toLowerCase().equals(titulo.toLowerCase())){
                return tareas.get(i);
            }
        }
        return null;
    }

    public boolean marcarCompleta(Tarea tarea, String colaborador){
        if(tarea.estaCompleta()){
            return false;
        }
        tarea.setCompleta(colaborador);
        return true;
    }

    public String buscarTareasPorColaborador(String colaborador){
        String tareasColaborador = "";
        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).getColaborador().toLowerCase().equals(colaborador.toLowerCase())){
                tareasColaborador += tareas.get(i);
            }
        }
        return tareasColaborador;
    }


}
