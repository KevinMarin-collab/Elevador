package ElevadorProyecto;

public class Boton {
    private int piso;
    private boolean presionado;

    public Boton(int piso) {
        this.piso = piso;
        this.presionado = false;
    }

    public void presionar() {
        presionado = true;
        System.out.println("Botón del piso " + piso + " presionado.");
    }

    public boolean esPresionado() {
        return presionado;
    }

    public int getPiso() {
        return piso;
    }
}
