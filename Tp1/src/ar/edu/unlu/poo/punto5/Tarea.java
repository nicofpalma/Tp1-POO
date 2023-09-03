package ar.edu.unlu.poo.punto5;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private boolean completa;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;
    private LocalDate fechaFinalizacion;

    private String colaborador = "";
    private Prioridad prioridad;
    enum Prioridad {
        ALTA,
        MEDIA,
        BAJA
    }

    public Tarea (String descripcion, String prioridad, boolean completa, LocalDate fechaLimite, LocalDate fechaRecordatorio){
        this.descripcion = descripcion;
        this.prioridad = Prioridad.valueOf(prioridad.toUpperCase());
        this.completa = completa;
        this.fechaLimite = fechaLimite;
        this.fechaRecordatorio = fechaRecordatorio;
    }
    public Tarea (String descripcion, String prioridad, boolean completa, LocalDate fechaLimite){
        this(descripcion, prioridad, completa, fechaLimite, fechaLimite.minusDays(1));
    }

    public String toString(){
        return
                "--- Información sobre la tarea --- \n" +
                "DESCRIPCIÓN: " + (estaVencida() ? "(Vencida) " + descripcion : descripcion) + "\n"
                + "COMPLETA: "
                        + (estaCompleta()
                            ? "SI"
                                + "\nFECHA DE FINALIZACIÓN: " + (getFechaFinalizacion() == null ? "No se conoce la fecha de finalización de esta tarea" : getFechaFinalizacion())
                                + "\nCOLABORADOR: " + getColaborador()
                            : "NO") + "\n"
                + "FECHA LÍMITE: " + fechaLimite + "\n"
                + "FECHA DE RECORDATORIO: " + (porVencer() ? "(Por vencer) " + fechaRecordatorio : fechaRecordatorio) + "\n"
                + "PRIORIDAD: " + prioridad + "\n"
                + "-----------------------------------\n";
    }

    public String getColaborador(){
        if(colaborador.equals("")){
            return "No se conoce al colaborador que finalizó esta tarea";
        }
        return colaborador;
    }

    public LocalDate getFechaFinalizacion(){
        return fechaFinalizacion;
    }

    public boolean porVencer(){
        if(fechaRecordatorio.isAfter(LocalDate.now()) || fechaRecordatorio.isEqual(LocalDate.now())){
            prioridad = Prioridad.ALTA;
            return true;
        }
        return false;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = Prioridad.valueOf(prioridad.toUpperCase());
    }

    public void setCompleta(String colaborador) {
        this.completa = true;
        this.fechaFinalizacion = LocalDate.now();
        this.colaborador = colaborador;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public boolean estaCompleta(){
        return completa;
    }

    public boolean estaVencida(){
        return fechaLimite.isBefore(LocalDate.now()) && !completa;
    }
}
