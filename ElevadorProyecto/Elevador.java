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
        if (!puertaElevador.isAbierta()) {
            if (pisoActual < numeroPisos) {
                moverAPiso(pisoActual + 1, "Subiendo");
            } else {
                System.out.println("Ya estás en el último piso.");
            }
        } else {
            System.out.println("No se puede mover: las puertas están abiertas.");
        }
    }

    // Metodo para bajar de piso
    public void bajar() {
        if (!puertaElevador.isAbierta()) {
            if (pisoActual > 1) {
                moverAPiso(pisoActual - 1, "Bajando");
            } else {
                System.out.println("Ya estás en el primer piso.");
            }
        } else {
            System.out.println("No se puede mover: las puertas están abiertas.");
        }
    }

    // Metodo para ir a un piso especifico
    public void irAPiso(int piso) {
        if (!puertaElevador.isAbierta()) {
            if (piso >= 1 && piso <= numeroPisos) {
                String direccion = (piso > pisoActual) ? "Subiendo" : (piso < pisoActual) ? "Bajando" : "Estacionado";
                moverAPiso(piso, direccion);
            } else {
                System.out.println("Piso inválido.");
            }
        } else {
            System.out.println("No se puede mover: las puertas están abiertas.");
        }
    }

    // Metodo privado para mover al piso deseado, simulando el viaje
    private void moverAPiso(int pisoDestino, String direccion) {
        int paso = (pisoDestino > pisoActual) ? 1 : -1;
        while (pisoActual != pisoDestino) {
            // Mostrar estado antes de incrementar
            tablero.mostrarEstado(pisoActual, direccion + " al piso " + pisoDestino);
            try {
                Thread.sleep(2000); // Simula 2 segundos por piso
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Incrementar después
            pisoActual += paso;
        }
        // Al llegar, abrir puertas
        System.out.println("Piso " + pisoActual + ", abriendo puertas.");
        abrirPuerta();
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
