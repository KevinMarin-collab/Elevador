package ElevadorProyecto;

public class BotonExterior extends Boton {
    private boolean direccionSubir;

    public BotonExterior(int piso, boolean direccionSubir) {
        super(piso);
        this.direccionSubir = direccionSubir;
    }

    public void presionar() {
        super.presionar();
        if (direccionSubir) {
            System.out.println("Llamando al elevador para subir.");
        } else {
            System.out.println("Llamando al elevador para bajar.");
        }
    }
}
