package ProyectoElevador;

// Esta clase controla si están abiertas o cerradas,
// y tiene un truco: se cierran solas después de 3 segundos si las dejas abiertas.
public class Puerta {
    private boolean abierta; // ¿Están abiertas? true o false.
    private Thread autoCerrarThread; // Un hilo secreto para cerrar automáticamente.

    // Constructor: Empezamos con puertas cerradas, como debe ser.
    public Puerta() {
        this.abierta = false;
    }

    // ¡Abrir puertas! Las ponemos abiertas y activamos el temporizador para cerrarlas solas.
    public void abrir() {
        abierta = true;
        System.out.println("Puerta abierta.");
        // Si había un hilo anterior, lo paramos.
        if (autoCerrarThread != null && autoCerrarThread.isAlive()) {
            autoCerrarThread.interrupt();
        }
        // Creamos un nuevo hilo que espera 3 segundos y cierra si aún están abiertas.
        autoCerrarThread = new Thread(() -> {
            try {
                Thread.sleep(3000); // ¡Espera 3 segundos!
                if (abierta) { // Verificamos si siguen abiertas.
                    cerrar(); // ¡Cerramos automáticamente!
                }
            } catch (InterruptedException e) {
                // Si nos interrumpen (ej. cerrar manualmente), no hacemos nada.
            }
        });
        autoCerrarThread.start(); // ¡Arranca el hilo!
    }

    // ¡Cerrar puertas! Las ponemos cerradas y paramos el hilo si estaba activo.
    public void cerrar() {
        abierta = false;
        System.out.println("Puerta cerrada.");
        if (autoCerrarThread != null) {
            autoCerrarThread.interrupt(); // Detenemos el auto-cierre.
        }
    }

    // Solo para chequear si están abiertas o no.
    public boolean isAbierta() {
        return abierta;
    }
}