package ElevadorProyecto;

public class Elevador {
    // Creacion de variables principales del elevador
    private int pisoActual;
    private int numeroPisos;
    private Puerta puertaElevador;
    private Tablero tablero;

    // Inicializacion de el elevador
    public Elevador(int numeroPisos) {
        this.numeroPisos = numeroPisos;
        this.pisoActual = 1; // Empieza en el primer piso
        this.puertaElevador = new Puerta();
        this.tablero = new Tablero(pisoActual);
    }

    // Metodos para el funcionamiento del elevador
    // Metodo para subir de piso
    public void subir() {
        if (pisoActual < numeroPisos) {
            pisoActual++;
            tablero.mostrarEstado(pisoActual, "Subiendo");
        } else {
            System.out.println("Ya estás en el último piso.");
        }
    }

    // Metodo para bajar de piso
    public void bajar() {
        if (pisoActual > 1) {
            pisoActual--;
            tablero.mostrarEstado(pisoActual, "Bajando");
        } else {
            System.out.println("Ya estás en el primer piso.");
        }
    }

    // Metodo para ir a un piso especifico
    public void irAPiso(int piso) {
        if (piso >= 1 && piso <= numeroPisos) {
            pisoActual = piso;
            tablero.mostrarEstado(pisoActual, "Estacionado");
        } else {
            System.out.println("Piso inválido.");
        }
    }

    // Metodos para abrir y cerrar la puerta del elevador
    public void abrirPuerta() {
        puertaElevador.abrir();
    }

    public void cerrarPuerta() {
        puertaElevador.cerrar();
    }

    public int getPisoActual() {
        return pisoActual;
    }
}
