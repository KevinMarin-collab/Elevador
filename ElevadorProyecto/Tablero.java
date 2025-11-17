package ProyectoElevador;

// Muestra el piso actual y la dirección del elevador.
// Como una pantalla dentro del elevador que te dice dónde estás y adónde vas.
public class Tablero {
    private int pisoActual; // El piso que muestra.
    private String direccion; // La dirección (ej. "Subiendo").

    // Constructor: Empezamos con el piso inicial.
    public Tablero(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    // ¡Mostrar estado! Actualiza y imprime el piso y dirección de forma clara.
    public void mostrarEstado(int pisoActual, String direccion) {
        this.pisoActual = pisoActual;
        this.direccion = direccion;
        System.out.println("Piso actual: " + pisoActual + " - " + direccion); // ¡Info útil!
    }
}