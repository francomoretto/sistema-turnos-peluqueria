public class Cliente extends Persona {
    private int idCliente;

    public Cliente(int idCliente, String nombre, String telefono, String email) {
        super(nombre, telefono, email);
        this.idCliente = idCliente;
    }

    public int getIdCliente() { return idCliente; }

    @Override
    public void mostrarDatos() {
        System.out.println("[" + idCliente + "] " + nombre + " - Tel: " + telefono + " - Email: " + email);
    }
}
