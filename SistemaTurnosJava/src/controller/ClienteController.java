package controller;

import model.Cliente;
import model.OperacionesCRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ClienteController implements OperacionesCRUD {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Connection conn;

    public ClienteController(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public void agregar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(1, nombre, tel, email);
        clientes.add(cliente);
        try {
            String sql = "INSERT INTO Cliente (nombre, telefono, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getTelefono());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Cliente guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }



    @Override
    public void listar() {
        for (Cliente c : clientes) {
            c.mostrarDatos();
        }
    }

    public void cargarClientesDesdeDB() {
        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery("SELECT * FROM Cliente");
            while (rs.next()) {
                int id = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                Cliente c = new Cliente(id, nombre, telefono, email);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }

}
