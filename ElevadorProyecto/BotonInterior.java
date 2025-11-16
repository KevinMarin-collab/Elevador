package ElevadorProyecto;

public class BotonInterior extends Boton {
    public BotonInterior(int piso) {
        super(piso);
    }

    public void presionar() {
        super.presionar();
        System.out.println("Elevador se dirige al piso " + getPiso());
    }
}
