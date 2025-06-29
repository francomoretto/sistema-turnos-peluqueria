package model;

public class EstadoTurno {
    private static final String[] estados = {"Pendiente", "Confirmado", "Cancelado"};

    public static String[] getEstados() {
        return estados;
    }
}
