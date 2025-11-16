package ElevadorProyecto;

public class Tablero {
    private int pisoActual;
    private String direccion;

    public Tablero(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public void mostrarEstado(int pisoActual, String direccion) {
        this.pisoActual = pisoActual;
        this.direccion = direccion;
        System.out.println("Piso actual: " + pisoActual + " - Dirección: " + direccion);
    }
}
