package view;

import controller.ClienteController;
import controller.TurnoController;
import model.Cliente;
import model.Servicio;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsola {
    private ClienteController clienteController;
    private TurnoController turnoController;

    public MenuConsola(ClienteController clienteController, TurnoController turnoController,
                       ArrayList<Cliente> clientes, ArrayList<Servicio> servicios) {
        this.clienteController = clienteController;
        this.turnoController = turnoController;
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Crear Turno");
            System.out.println("4. Listar Turnos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> clienteController.agregar();
                case 2 -> clienteController.listar();
                case 3 -> turnoController.crearTurno();
                case 4 -> turnoController.listarTurnos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}
