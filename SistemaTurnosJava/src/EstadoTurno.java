public class EstadoTurno {
    private int idEstado;
    private String nombre;

    public EstadoTurno(int idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public int getIdEstado() { return idEstado; }
    public String getNombre() { return nombre; }

    public void mostrar() {
        System.out.println("[" + idEstado + "] " + nombre);
    }
}
