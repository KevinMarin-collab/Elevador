package ProyectoElevador;

// Heredan de Boton y se usan para seleccionar piso desde adentro del elevador.
// Cuando los presionas, dicen adónde va el elevador.
public class BotonInterior extends Boton {
    // Constructor: Igual que el padre, pero para botones internos.
    public BotonInterior(int piso) {
        super(piso);
    }

    // ¡Presionar con estilo! Primero hace lo del padre, luego avisa que el elevador se dirige ahí.
    public void presionar() {
        super.presionar(); // Llamamos al método del papá.
        System.out.println("Elevador se dirige al piso " + getPiso()); // ¡Mensaje extra!
    }
}