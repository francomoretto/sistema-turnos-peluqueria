package controller;

import model.Cliente;
import model.Servicio;
import model.Turno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TurnoController {
    private ArrayList<Turno> turnos = new ArrayList<>();
    private ArrayList<Cliente> clientes;
    private ArrayList<Servicio> servicios;
    private Connection conn;
    private int idTurno = 1;

    public TurnoController(Connection conn, ArrayList<Cliente> clientes, ArrayList<Servicio> servicios) {
        this.conn = conn;
        this.clientes = clientes;
        this.servicios = servicios;
    }

    public void crearTurno() {
        Scanner sc = new Scanner(System.in);

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Seleccione un cliente por ID:");
        for (Cliente c : clientes) {
            c.mostrarDatos();
        }

        int idC = sc.nextInt();
        sc.nextLine();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getIdCliente() == idC)
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Seleccione un servicio:");
        for (Servicio s : servicios) {
            s.mostrar();
        }

        int idS = sc.nextInt();
        sc.nextLine();
        Servicio servicio = servicios.stream()
                .filter(s -> s.getIdServicio() == idS)
                .findFirst()
                .orElse(null);

        if (servicio == null) {
            System.out.println("Servicio no encontrado.");
            return;
        }

        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        System.out.print("Hora (HH:MM): ");
        LocalTime hora = LocalTime.parse(sc.nextLine());

        System.out.println("Seleccione estado: Pendiente / Confirmado / Cancelado");
        String estado = sc.nextLine();

        Turno nuevo = new Turno(idTurno++, cliente, servicio, estado, fecha, hora);
        turnos.add(nuevo);

        try {
            String sql = "INSERT INTO Turno (idCliente, idServicio, fecha, hora, observaciones) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setInt(2, servicio.getIdServicio());
            stmt.setDate(3, java.sql.Date.valueOf(fecha));
            stmt.setTime(4, java.sql.Time.valueOf(hora));
            stmt.setString(5, estado); // Guarda el estado en observaciones
            stmt.executeUpdate();
            System.out.println("Turno guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar turno: " + e.getMessage());
        }
    }

    public void listarTurnos() {
        if (turnos.isEmpty()) {
            System.out.println("No hay turnos registrados en memoria.");
            return;
        }

        for (Turno t : turnos) {
            t.mostrarResumen();
        }
    }
}
