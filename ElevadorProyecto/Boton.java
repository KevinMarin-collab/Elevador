package ProyectoElevador;

// Esta es la clase base para todos los botones del elevador.
// Representa un botón genérico con un piso asignado y si ha sido presionado.
public class Boton {
    private int piso; // ¿A qué piso lleva este botón?
    private boolean presionado; // ¿Lo han presionado? true o false.

    // Constructor: Creamos el botón con su piso y empezamos sin presionar.
    public Boton(int piso) {
        this.piso = piso;
        this.presionado = false;
    }

    // ¡Presionar! Marcamos que lo presionaron y mostramos un mensaje amigable.
    public void presionar() {
        presionado = true;
        System.out.println("Botón del piso " + piso + " presionado.");
    }

    // Chequeamos si está presionado.
    public boolean esPresionado() {
        return presionado;
    }

    // Obtenemos el piso al que va.
    public int getPiso() {
        return piso;
    }
}