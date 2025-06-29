import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_turnos";
    private static final String USER = "root"; // Cambialo si tu user es otro
    private static final String PASSWORD = "central1889"; // Cambialo si es otro

    public static Connection conectar() {
        try {
            // Carga el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conexión con la base
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver JDBC no encontrado -> " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL -> " + e.getMessage());
        }
        return null;
    }
}
