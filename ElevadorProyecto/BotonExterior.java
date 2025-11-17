package ProyectoElevador;

// También heredan de Boton, pero para llamar al elevador desde fuera.
// Tienen una dirección: subir o bajar.
public class BotonExterior extends Boton {
    private boolean direccionSubir; // ¿Es para subir (true) o bajar (false)?

    // Constructor: Agregamos la dirección además del piso.
    public BotonExterior(int piso, boolean direccionSubir) {
        super(piso);
        this.direccionSubir = direccionSubir;
    }

    // ¡Presionar desde afuera! Hace lo del padre y avisa si es para subir o bajar.
    public void presionar() {
        super.presionar(); // Llamamos al papá.
        if (direccionSubir) {
            System.out.println("Llamando al elevador para subir."); // ¡Subiendo!
        } else {
            System.out.println("Llamando al elevador para bajar."); // ¡Bajando!
        }
    }
}