import controller.ClienteController;
import controller.TurnoController;
import view.MenuConsola;
import model.Servicio;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection conn = BaseDatos.conectar();

        // Crear lista de servicios
        ArrayList<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio(1, "Corte", 2500, 30));
        servicios.add(new Servicio(2, "Coloración", 6000, 90));
        servicios.add(new Servicio(3, "Peinado", 3000, 45));

        // ClienteController con carga de clientes desde DB
        ClienteController clienteController = new ClienteController(conn);
        clienteController.cargarClientesDesdeDB();

        // TurnoController recibe clientes + servicios
        TurnoController turnoController = new TurnoController(conn, clienteController.getClientes(), servicios);

        // Menú principal
        MenuConsola menu = new MenuConsola(clienteController, turnoController,
                clienteController.getClientes(), servicios);
        menu.mostrarMenu();
    }
}
