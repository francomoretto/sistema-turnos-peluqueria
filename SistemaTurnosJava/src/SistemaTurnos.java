import java.util.*;
import java.time.*;

public class SistemaTurnos {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Turno> turnos = new ArrayList<>();
    private static ArrayList<Servicio> servicios = new ArrayList<>();
    private static ArrayList<EstadoTurno> estados = new ArrayList<>();
    private static int clienteId = 1;
    private static int turnoId = 1;

    public static void main(String[] args) {
        cargarServicios();
        cargarEstados();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n---- Menú de Turnos - Estilo Único ----");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Crear Turno");
            System.out.println("3. Listar Turnos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente(sc);
                case 2 -> crearTurno(sc);
                case 3 -> listarTurnos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void registrarCliente(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        Cliente c = new Cliente(clienteId++, nombre, telefono, email);
        clientes.add(c);
        System.out.println("Cliente registrado.");
    }

    private static void crearTurno(Scanner sc) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("Seleccione un cliente:");
        for (Cliente c : clientes) c.mostrarDatos();
        int idC = sc.nextInt(); sc.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.getIdCliente() == idC).findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Seleccione un servicio:");
        for (Servicio s : servicios) s.mostrar();
        int idS = sc.nextInt(); sc.nextLine();
        Servicio servicio = servicios.stream().filter(s -> s.getIdServicio() == idS).findFirst().orElse(null);
        if (servicio == null) {
            System.out.println("Servicio no encontrado.");
            return;
        }

        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("Hora (HH:MM): ");
        LocalTime hora = LocalTime.parse(sc.nextLine());

        System.out.println("Seleccione estado:");
        for (EstadoTurno e : estados) e.mostrar();
        int idE = sc.nextInt(); sc.nextLine();
        EstadoTurno estado = estados.stream().filter(e -> e.getIdEstado() == idE).findFirst().orElse(null);
        if (estado == null) {
            System.out.println("Estado inválido.");
            return;
        }

        Turno t = new Turno(turnoId++, cliente, servicio, estado, fecha, hora);
        turnos.add(t);
        System.out.println("Turno creado con éxito.");
    }

    private static void listarTurnos() {
        if (turnos.isEmpty()) {
            System.out.println("No hay turnos registrados.");
            return;
        }
        for (Turno t : turnos) {
            t.mostrarResumen();
        }
    }

    private static void cargarServicios() {
        servicios.add(new Servicio(1, "Corte", 2500, 30));
        servicios.add(new Servicio(2, "Coloración", 6000, 90));
        servicios.add(new Servicio(3, "Peinado", 3000, 45));
    }

    private static void cargarEstados() {
        estados.add(new EstadoTurno(1, "Pendiente"));
        estados.add(new EstadoTurno(2, "Confirmado"));
        estados.add(new EstadoTurno(3, "Cancelado"));
    }
}
