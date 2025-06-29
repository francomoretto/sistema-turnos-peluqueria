package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private int idTurno;
    private Cliente cliente;
    private Servicio servicio;
    private String estado;
    private LocalDate fecha;
    private LocalTime hora;

    public Turno(int idTurno, Cliente cliente, Servicio servicio, String estado, LocalDate fecha, LocalTime hora) {
        this.idTurno = idTurno;
        this.cliente = cliente;
        this.servicio = servicio;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public void mostrarResumen() {
        System.out.println("Turno #" + idTurno + " | " + fecha + " " + hora +
                " | Cliente: " + cliente.getNombre() +
                " | Servicio: " + servicio.getNombre() +
                " | Estado: " + estado);
    }
}
